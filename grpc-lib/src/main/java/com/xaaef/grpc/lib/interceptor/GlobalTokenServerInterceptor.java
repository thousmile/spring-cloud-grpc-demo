package com.xaaef.grpc.lib.interceptor;


import cn.hutool.core.util.ArrayUtil;
import com.xaaef.grpc.lib.context.GrpcContext;
import com.xaaef.grpc.lib.dto.CustomMetadata;
import com.xaaef.grpc.lib.pb.TokenInfo;
import com.xaaef.grpc.lib.util.JsonUtils;
import com.xaaef.grpc.lib.util.MsgpackUtils;
import com.xaaef.grpc.lib.util.ProtobufUtils;
import io.grpc.*;
import io.grpc.protobuf.ProtoUtils;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
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
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call,
                                                                 Metadata headers,
                                                                 ServerCallHandler<ReqT, RespT> next) {
        GrpcContext.reset();
        String fullMethodName = call.getMethodDescriptor().getFullMethodName();
        log.debug("grpc request address : {}", fullMethodName);

        // 获取 租户ID
        var tenantId = headers.get(TENANT_ID);
        if (!StringUtils.hasText(tenantId)) {
            var status = Status.UNAUTHENTICATED.withDescription("Invalid tenantId");
            return handleInterceptorException(status, call);
        } else {
            GrpcContext.setTenantId(tenantId);
        }

        log.info("3.Server TenantId: \n{}", GrpcContext.getTenantId());

        // 获取 token 信息 protobuf 格式
        var tokenInfo = headers.get(TOKEN_INFO);
        if (Objects.isNull(tokenInfo)) {
            var status = Status.UNAUTHENTICATED.withDescription("Invalid tokenInfo");
            return handleInterceptorException(status, call);
        } else {
            GrpcContext.setTokenInfo(tokenInfo);
        }

        log.debug("TokenInfo Protobuf : \n{}", GrpcContext.getTokenInfo());

        String print = ProtobufUtils.toJson(GrpcContext.getTokenInfo());
        log.debug("TokenInfo Json : \n{}", print);

        // 获取 token 信息 二进制 格式
        var bytes = headers.get(CUSTOM_BINARY);
        if (ArrayUtil.isNotEmpty(bytes)) {
            var customMetadata = MsgpackUtils.toPojo(bytes, CustomMetadata.class);
            log.debug("Custom Metadata: \n{}", JsonUtils.toFormatJson(customMetadata));
        }


        try {
            var delegate = next.startCall(call, headers);

            return new ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>(delegate) {

                @Override
                public void onMessage(ReqT message) {
                    try {
                        super.onMessage(message); // Here onNext is called (in case of client streams)
                    } catch (Exception ex) {
                        handleEndpointException(ex, call);
                    }
                }

                @Override
                public void onHalfClose() {
                    try {
                        super.onHalfClose();
                    } catch (Exception ex) {
                        handleEndpointException(ex, call);
                    }
                }

                @Override
                public void onComplete() {
                    super.onComplete();
                    // 清除 传递到 RPC 线程中 ThreadLocal 的数据。 防止其他请求复用此线程的数据
                    GrpcContext.reset();
                }

            };
        } catch (Exception ex) {
            return handleInterceptorException(
                    Status.INTERNAL.withDescription(ex.getMessage()),
                    call
            );
        }

    }


    private <ReqT, RespT> void handleEndpointException(Exception t, ServerCall<ReqT, RespT> serverCall) {
        serverCall.close(Status.INTERNAL
                .withCause(t)
                .withDescription(t.getMessage()), new Metadata());
        // 清除 传递到 RPC 线程中 ThreadLocal 的数据。 防止其他请求复用此线程的数据
        GrpcContext.reset();
    }


    private <ReqT, RespT> ServerCall.Listener<ReqT> handleInterceptorException(Status status, ServerCall<ReqT, RespT> serverCall) {
        serverCall.close(status, new Metadata());
        return new ServerCall.Listener<ReqT>() {

            @Override
            public void onComplete() {
                // 清除 传递到 RPC 线程中 ThreadLocal 的数据。 防止其他请求复用此线程的数据
                GrpcContext.reset();
                super.onComplete();
            }

        };
    }

}

