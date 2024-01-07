package com.xaaef.grpc.lib.interceptor;


import com.xaaef.grpc.lib.context.GrpcContext;
import com.xaaef.grpc.lib.dto.CustomMetadata;
import com.xaaef.grpc.lib.pb.TokenInfo;
import com.xaaef.grpc.lib.util.JsonUtils;
import com.xaaef.grpc.lib.util.MsgpackUtils;
import io.grpc.*;
import io.grpc.protobuf.ProtoUtils;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.StringUtils;

import java.util.Objects;

import static io.grpc.Metadata.*;


/**
 * <p>
 * 服务端 token拦截器
 * </p>
 *
 * @author WangChenChen
 * @version 1.1
 * @date 2022/11/19 15:10
 */


@Slf4j
@GrpcGlobalServerInterceptor
public class GlobalTokenServerInterceptor implements ServerInterceptor {

    // 租户ID string 格式
    static final Metadata.Key<String> TENANT_ID = Metadata.Key.of("tenantId", ASCII_STRING_MARSHALLER);

    // token 信息 protobuf 格式
    static final Metadata.Key<TokenInfo> TOKEN_INFO = ProtoUtils.keyForProto(TokenInfo.getDefaultInstance());

    // 二进制 格式 , name 后缀必须是 -bin
    static final Metadata.Key<byte[]> CUSTOM_BINARY = Metadata.Key.of("custom" + BINARY_HEADER_SUFFIX, BINARY_BYTE_MARSHALLER);


    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata,
                                                                 ServerCallHandler<ReqT, RespT> serverCallHandler) {
        GrpcContext.reset();
        // 获取 租户ID
        var tenantId = metadata.get(TENANT_ID);
        if (!StringUtils.hasText(tenantId)) {
            var status = Status.UNAUTHENTICATED.withDescription("Invalid tenantId");
            return handleException(status, serverCall);
        } else {
            GrpcContext.setTenantId(tenantId);
        }
        // 判断当前请求是否，忽略认证
        var ignore = GrpcContext.IGNORE_AUTH_METHOD.contains(serverCall.getMethodDescriptor());
        log.info("address : {}  ignore auth: {} TenantId: {} ", serverCall.getMethodDescriptor().getFullMethodName(), ignore, GrpcContext.getTenantId());
        if (!ignore) {
            // 获取 token 信息 protobuf 格式
            var tokenInfo = metadata.get(TOKEN_INFO);
            if (Objects.isNull(tokenInfo)) {
                var status = Status.UNAUTHENTICATED.withDescription("Invalid tokenInfo");
                return handleException(status, serverCall);
            } else {
                GrpcContext.setTokenInfo(tokenInfo);
            }
            // 获取 token 信息 二进制 格式
            var bytes = metadata.get(CUSTOM_BINARY);
            if (ArrayUtils.isNotEmpty(bytes)) {
                var customMetadata = MsgpackUtils.toPojo(bytes, CustomMetadata.class);
                log.debug("Custom Metadata: \n{}", JsonUtils.toFormatJson(customMetadata));
            }
        }
        var delegate = serverCallHandler.startCall(serverCall, metadata);
        return new ForwardingServerCallListener.SimpleForwardingServerCallListener<>(delegate) {

            /**
             * 贯穿整个请求的整个生命周期。
             */
            @Override
            public void onHalfClose() {
                log.info("start interceptor onHalfClose : .....");
                super.onHalfClose();
                log.info("end interceptor onHalfClose : .....");
            }

            /**
             * 代表本次请求正常结束
             */
            @Override
            public void onComplete() {
                try {
                    super.onComplete();
                } finally {
                    // 清除 传递到 RPC 线程中 ThreadLocal 的数据。 防止其他请求复用此线程的数据
                    GrpcContext.reset();
                    log.info("server interceptor onComplete : .....");
                }
            }

            /**
             * 代表本次请求被取消掉，通常发生在服务端执行出现异常的情况会被调用。
             * 例如请求超时，会执行到这个方法。
             */
            @Override
            public void onCancel() {
                try {
                    super.onCancel();
                } finally {
                    GrpcContext.reset();
                    log.info("server interceptor onCancel : .....");
                }
            }

        };
    }


    private <ReqT, RespT> ServerCall.Listener<ReqT> handleException(Status status, ServerCall<ReqT, RespT> serverCall) {
        serverCall.close(status, new Metadata());
        return new ServerCall.Listener<>() {

            @Override
            public void onComplete() {
                super.onComplete();
                // 清除 传递到 RPC 线程中 ThreadLocal 的数据。 防止其他请求复用此线程的数据
                GrpcContext.reset();
            }

        };
    }


}

