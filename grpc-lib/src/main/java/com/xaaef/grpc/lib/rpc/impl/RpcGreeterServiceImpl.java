package com.xaaef.grpc.lib.rpc.impl;

import cn.hutool.core.util.StrUtil;
import com.google.protobuf.StringValue;
import com.xaaef.grpc.lib.greet.GreeterGrpc;
import com.xaaef.grpc.lib.greet.HelloRequest;
import com.xaaef.grpc.lib.rpc.RpcGreeterService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RpcGreeterServiceImpl implements RpcGreeterService {

    @GrpcClient("grpc-server")
    private GreeterGrpc.GreeterBlockingStub blockingStub;

    private final Resilience4JCircuitBreakerFactory cbFactory;

    public RpcGreeterServiceImpl(Resilience4JCircuitBreakerFactory cbFactory) {
        this.cbFactory = cbFactory;
    }

    /**
     * TODO 使用方法的断路器
     *
     * @author WangChenChen
     * @date 2022/11/13 10:17
     */
    @Override
    public String sayHello(String name) {
        var request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        long start = System.currentTimeMillis();
        var result = cbFactory.create("sayHello").run(
                () -> blockingStub.sayHello(request).getMessage(),
                ex -> {
                    ex.printStackTrace();
                    var err = StrUtil.format("[grpc] sayHello({}) 熔断，原因: {}", name, ex.getMessage());
                    log.error(err);
                    return err;
                });
        long time = System.currentTimeMillis() - start;
        log.info("[grpc] blockingStub.sayHello() 耗时: {} ms", time);
        return result;
    }


    /**
     * TODO 使用注解的断路器
     *
     * @author WangChenChen
     * @date 2022/11/13 10:17
     */
    @CircuitBreaker(name = "isChinese", fallbackMethod = "isChineseFallback")
    @Override
    public boolean isChinese(String name) {
        long start = System.currentTimeMillis();
        var result = blockingStub.isChinese(StringValue.of(name)).getValue();
        long time = System.currentTimeMillis() - start;
        log.info("[grpc] blockingStub.sayHello() 耗时: {} ms", time);
        return result;
    }

    private boolean isChineseFallback(String name, StatusRuntimeException ex) {
        ex.printStackTrace();
        log.error("[grpc] isChineseFallback({}) 熔断: {}", name, ex.getMessage());
        return false;
    }

}
