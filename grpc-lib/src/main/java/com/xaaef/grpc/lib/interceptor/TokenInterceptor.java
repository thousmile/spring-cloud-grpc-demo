package com.xaaef.grpc.lib.interceptor;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.xaaef.grpc.lib.context.GrpcContext;
import com.xaaef.grpc.lib.domain.TokenInfo;
import com.xaaef.grpc.lib.dto.CustomMetadata;
import com.xaaef.grpc.lib.util.MsgpackUtils;
import io.grpc.*;
import io.grpc.protobuf.ProtoUtils;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.interceptor.GrpcGlobalClientInterceptor;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static io.grpc.Metadata.*;


public class TokenInterceptor {

    // 租户ID
    private static final Metadata.Key<String> TENANT_ID = Metadata.Key.of("tenantId", ASCII_STRING_MARSHALLER);

    // token 信息 protobuf 格式
    private static final Metadata.Key<TokenInfo> TOKEN_INFO = ProtoUtils.keyForProto(TokenInfo.getDefaultInstance());

    // token 信息 二进制 格式 , name 后缀必须是 -bin
    private static final Metadata.Key<byte[]> TOKEN_INFO_BYTES = Metadata.Key.of("customMetadata" + BINARY_HEADER_SUFFIX, BINARY_BYTE_MARSHALLER);


    /**
     * TODO 服务端 token拦截器
     *
     * @author WangChenChen
     * @date 2022/11/13 12:53
     */
    @Slf4j
    @GrpcGlobalServerInterceptor
    public static class TokenServerInterceptor implements ServerInterceptor {

        @Override
        public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call,
                                                                     Metadata headers,
                                                                     ServerCallHandler<ReqT, RespT> next) {
            GrpcContext.reset();
            String fullMethodName = call.getMethodDescriptor().getFullMethodName();
            // log.info("grpc request address : {}", fullMethodName);
            // 获取 租户ID
            var tenantId = headers.get(TENANT_ID);
            if (!StringUtils.hasText(tenantId)) {
                var status = Status.UNAUTHENTICATED.withDescription("Invalid tenantId");
                return handleInterceptorException(status, call);
            } else {
                GrpcContext.setTenantId(tenantId);
            }

            log.info("3.Server TenantId: String \n{}", GrpcContext.getTenantId());


            // 获取 token 信息 protobuf 格式
            var tokenInfo = headers.get(TOKEN_INFO);
            if (Objects.isNull(tokenInfo)) {
                var status = Status.UNAUTHENTICATED.withDescription("Invalid tokenInfo");
                return handleInterceptorException(status, call);
            } else {
                GrpcContext.setTokenInfo(tokenInfo);
            }

            // log.info("TokenInfo Protobuf : \n{}", GrpcContext.getTokenInfo());

            try {
                String print = JsonFormat.printer().print(GrpcContext.getTokenInfo());
                // log.info("TokenInfo Json : \n{}", print);
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }


            // 获取 token 信息 二进制 格式
            var bytes = headers.get(TOKEN_INFO_BYTES);
            if (ArrayUtil.isNotEmpty(bytes)) {
                var customMetadata = MsgpackUtils.toPojo(bytes, CustomMetadata.class);
                // log.info("CustomMetadata: \n{}", JsonUtils.toFormatJson(customMetadata));
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


    /**
     * TODO 客户端 token拦截器
     *
     * @author WangChenChen
     * @date 2022/11/13 12:53
     */
    @Slf4j
    @GrpcGlobalClientInterceptor
    public static class TokenClientInterceptor implements ClientInterceptor {

        @Override
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor,
                                                                   CallOptions callOptions,
                                                                   Channel channel) {
            var delegate = channel.newCall(methodDescriptor, callOptions);
            return new ForwardingClientCall.SimpleForwardingClientCall<>(delegate) {

                @Override
                public void start(Listener<RespT> responseListener, Metadata headers) {
                    var tenantId = GrpcContext.getTenantId();
                    var tokenInfo = GrpcContext.getTokenInfo();
                    log.info("2.Client TenantId: String \n{}", tenantId);
                    if (StringUtils.hasText(tenantId)) {
                        // 添加 租户ID string 类型
                        headers.put(TENANT_ID, tenantId);
                    }

                    if (Objects.nonNull(tokenInfo)) {
                        // 添加 token 信息 protobuf 格式
                        headers.put(TOKEN_INFO, tokenInfo);
                    }

                    // 添加 元数据 二进制 格式
                    headers.put(TOKEN_INFO_BYTES, randomBytes());

                    super.start(new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(responseListener) {

                        @Override
                        public void onClose(Status status, Metadata trailers) {
                            log.info("4.onClose: \n{}", GrpcContext.getTenantId());
                            // 清除 传递到 RPC 线程中 ThreadLocal 的数据。 防止其他请求复用此线程的数据
                            GrpcContext.reset();
                            super.onClose(status, trailers);
                        }

                    }, headers);
                }

            };

        }


        /**
         * TODO 随机生成 类。并且转换为 字节数组
         *
         * @author WangChenChen
         * @date 2022/11/13 11:52
         */
        private static byte[] randomBytes() {
            var customMetadata = CustomMetadata.builder()
                    .id(IdUtil.nanoId())
                    .size(RandomUtil.randomInt())
                    .date(LocalDate.now())
                    .time(LocalTime.now())
                    .dateTime(LocalDateTime.now())
                    .d1(RandomUtil.randomDouble())
                    .list(RandomUtil.randomEleList(List.of("A", "B", "C", "D", "E", "F", "G"), 3))
                    .maps(
                            Map.of(
                                    "age", RandomUtil.randomInt(),
                                    "id", IdUtil.objectId(),
                                    "msg", RandomUtil.randomDouble()
                            )
                    )
                    .build();
            return MsgpackUtils.toBytes(customMetadata);
        }

    }


}
