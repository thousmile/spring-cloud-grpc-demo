package com.xaaef.grpc.client;

import cn.hutool.core.util.StrUtil;
import com.google.protobuf.StringValue;
import com.xaaef.grpc.lib.greet.GreeterGrpc;
import com.xaaef.grpc.lib.greet.HelloRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class GrpcClientService {

    @GrpcClient("grpc-server")
    private GreeterGrpc.GreeterBlockingStub blockingStub;


    @CircuitBreaker(name = "sayHello", fallbackMethod = "sayHelloFallback")
    public String sayHello(String name) {
        var request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        long l = System.currentTimeMillis();
        String message = blockingStub.sayHello(request).getMessage();
        long l2 = System.currentTimeMillis() - l;
        log.info("[grpc] blockingStub.sayHello() 耗时: {}", l2);
        return message;
    }


    @CircuitBreaker(name = "isChinese", fallbackMethod = "sayHelloFallback")
    public boolean isChinese(String name) {
        var request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        long l = System.currentTimeMillis();
        var message = blockingStub.isChinese(StringValue.of(name)).getValue();
        long l2 = System.currentTimeMillis() - l;
        log.info("[grpc] blockingStub.isChinese() 耗时: {}", l2);
        return message;
    }


    private String sayHelloFallback(String name, Throwable ex) {
        return StrUtil.format("sayHello({}) 熔断，原因: {}", name, ex.getMessage());
    }


}
