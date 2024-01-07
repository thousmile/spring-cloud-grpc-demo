package com.xaaef.grpc.lib.interceptor;


import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.xaaef.grpc.lib.context.GrpcContext;
import com.xaaef.grpc.lib.dto.CustomMetadata;
import com.xaaef.grpc.lib.util.MsgpackUtils;
import io.grpc.*;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.interceptor.GrpcGlobalClientInterceptor;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

import static com.xaaef.grpc.lib.interceptor.GlobalTokenServerInterceptor.*;


/**
 * <p>
 * 客户端 token拦截器
 * </p>
 *
 * @author WangChenChen
 * @version 1.1
 * @date 2022/11/19 15:11
 */


@Slf4j
@GrpcGlobalClientInterceptor
public class GlobalTokenClientInterceptor implements ClientInterceptor {


    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor,
                                                               CallOptions callOptions,
                                                               Channel channel) {
        var start = new AtomicLong(System.currentTimeMillis());
        var delegate = channel.newCall(methodDescriptor, callOptions);
        return new ForwardingClientCall.SimpleForwardingClientCall<>(delegate) {

            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                // 添加 租户ID string 类型
                if (StringUtils.hasText(GrpcContext.getTenantId())) {
                    headers.put(TENANT_ID, GrpcContext.getTenantId());
                }
                // 添加 token 信息 protobuf 格式
                if (Objects.nonNull(GrpcContext.getTokenInfo())) {
                    headers.put(TOKEN_INFO, GrpcContext.getTokenInfo());
                }
                // 添加 自定义 二进制 格式
                headers.put(CUSTOM_BINARY, randomBytes());
                super.start(new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(responseListener) {
                    @Override
                    public void onClose(Status status, Metadata trailers) {
                        long time = System.currentTimeMillis() - start.get();
                        log.info("[grpc] {} time consuming: {} ms", methodDescriptor.getFullMethodName(), time);
                        super.onClose(status, trailers);
                    }
                }, headers);
            }
        };
    }


    /**
     * 随机生成 类。并且转换为 字节数组
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
