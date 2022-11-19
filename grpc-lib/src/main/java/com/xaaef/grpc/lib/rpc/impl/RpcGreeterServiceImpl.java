package com.xaaef.grpc.lib.rpc.impl;


import cn.hutool.core.util.StrUtil;
import com.google.protobuf.StringValue;
import com.xaaef.grpc.lib.domain.UserInfo;
import com.xaaef.grpc.lib.greet.GreeterGrpc;
import com.xaaef.grpc.lib.greet.HelloRequest;
import com.xaaef.grpc.lib.rpc.RpcGreeterService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class RpcGreeterServiceImpl implements RpcGreeterService {

    @GrpcClient("grpc-server")
    private GreeterGrpc.GreeterBlockingStub blockingStub;


    @CircuitBreaker(name = "sayHello", fallbackMethod = "sayHelloFallback")
    @Override
    public String sayHello(String name) {
        var request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        return blockingStub.sayHello(request).getMessage();
    }


    private String sayHelloFallback(String name, StatusRuntimeException ex) {
        var err = StrUtil.format("[grpc] sayHello({}) 熔断，原因: {}", name, ex.getMessage());
        log.error(err);
        return err;
    }


    @CircuitBreaker(name = "getUserInfo", fallbackMethod = "getUserInfoFallback1")
    @Override
    public UserInfo getUserInfo(String name) {
        return blockingStub.getUserInfo(StringValue.of(name));
    }


    private UserInfo getUserInfoFallback1(String name, StatusRuntimeException ex) {
        log.error("[grpc] getUserInfoFallback({}) 断路器: {}", name, ex.getMessage());
        return UserInfo.getDefaultInstance();
    }


}
