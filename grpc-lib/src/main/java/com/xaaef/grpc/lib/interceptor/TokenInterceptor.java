package com.xaaef.grpc.lib.interceptor;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.xaaef.grpc.lib.context.GrpcContext;
import com.xaaef.grpc.lib.domain.TokenInfo;
import com.xaaef.grpc.lib.dto.CustomMetadata;
import com.xaaef.grpc.lib.util.JsonUtils;
import com.xaaef.grpc.lib.util.MsgpackUtils;
import io.grpc.*;
import io.grpc.protobuf.ProtoUtils;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.interceptor.GrpcGlobalClientInterceptor;
import net.devh.boot.grpc.server.error.GrpcExceptionListener;
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

    @Slf4j
    @GrpcGlobalServerInterceptor
    public static class TokenServerInterceptor implements ServerInterceptor {

        @Override
        public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call,
                                                                     Metadata headers,
                                                                     ServerCallHandler<ReqT, RespT> next) {
            String fullMethodName = call.getMethodDescriptor().getFullMethodName();
            log.info("grpc request address : {}", fullMethodName);

            // 获取 租户ID
            var tenantId = headers.get(TENANT_ID);
            if (!StringUtils.hasText(tenantId)) {
                var status = Status.UNAUTHENTICATED.withDescription("Invalid tenantId");
                return handleInterceptorException(status, call);
            } else {
                GrpcContext.setTenantId(tenantId);
            }

            log.info("TenantId: String \n{}", GrpcContext.getTenantId());


            // 获取 token 信息 protobuf 格式
            var tokenInfo = headers.get(TOKEN_INFO);
            if (Objects.isNull(tokenInfo)) {
                var status = Status.UNAUTHENTICATED.withDescription("Invalid tokenInfo");
                return handleInterceptorException(status, call);
            } else {
                GrpcContext.setTokenInfo(tokenInfo);
            }

            log.info("TokenInfo Protobuf : \n{}", GrpcContext.getTokenInfo());

            try {
                String print = JsonFormat.printer().print(GrpcContext.getTokenInfo());
                log.info("TokenInfo Json : \n{}", print);
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }


            // 获取 token 信息 二进制 格式
            var bytes = headers.get(TOKEN_INFO_BYTES);
            if (ArrayUtil.isNotEmpty(bytes)) {
                var customMetadata = MsgpackUtils.toPojo(bytes, CustomMetadata.class);
                log.info("CustomMetadata: \n{}", JsonUtils.toFormatJson(customMetadata));
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
        }


        private <ReqT, RespT> ServerCall.Listener<ReqT> handleInterceptorException(Status status, ServerCall<ReqT, RespT> serverCall) {
            serverCall.close(status, new Metadata());
            return new ServerCall.Listener<ReqT>() {
            };
        }

    }


    @Slf4j
    @GrpcGlobalClientInterceptor
    public static class TokenClientInterceptor implements ClientInterceptor {

        @Override
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor,
                                                                   CallOptions callOptions,
                                                                   Channel channel) {
            return new ForwardingClientCall.SimpleForwardingClientCall<>(channel.newCall(methodDescriptor, callOptions)) {

                @Override
                public void start(Listener<RespT> responseListener, Metadata headers) {
                    if (StringUtils.hasText(GrpcContext.getTenantId())) {
                        // 添加租户ID
                        headers.put(TENANT_ID, GrpcContext.getTenantId());
                    }
                    if (Objects.nonNull(GrpcContext.getTokenInfo())) {
                        // 添加 token 信息 protobuf 格式
                        headers.put(TOKEN_INFO, GrpcContext.getTokenInfo());
                    }

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

                    byte[] bytes = MsgpackUtils.toBytes(customMetadata);

                    // 添加 token 信息 二进制 格式
                    headers.put(TOKEN_INFO_BYTES, bytes);

                    super.start(responseListener, headers);
                }

            };

        }

    }


}
