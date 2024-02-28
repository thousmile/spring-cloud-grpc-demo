package com.xaaef.grpc.lib.rpc.impl;


import cn.hutool.core.util.StrUtil;
import com.google.protobuf.StringValue;
import com.xaaef.grpc.lib.pb.ConfigGrpc;
import com.xaaef.grpc.lib.rpc.RpcConfigService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;


@Slf4j
@Service
public class RpcConfigServiceImpl implements RpcConfigService {

    @GrpcClient("grpc-demo1")
    private ConfigGrpc.ConfigBlockingStub blockingStub;

    @GrpcClient("grpc-demo1")
    private ConfigGrpc.ConfigFutureStub futureStub;


    @Override
    public String getStringValue(String key) {
        return blockingStub.getStringValue(StringValue.of(key)).getValue();
    }


    @Override
    public Boolean getBoolValue(String key) {
        return blockingStub.getBoolValue(StringValue.of(key)).getValue();
    }


    @TimeLimiter(name = "getNumberValue", fallbackMethod = "getNumberValueFallback")
    @CircuitBreaker(name = "getNumberValue", fallbackMethod = "getNumberValueFallback")
    public CompletableFuture<Long> getNumberValue(String key) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        var request = StringValue.of(key);
        return CompletableFuture
                .completedFuture(
                        blockingStub.getNumberValue(request).getValue()
                );
    }


    public CompletableFuture<Long> getNumberValueFallback(String key, Exception ex) {
        var err = StrUtil.format("[grpc] getNumberValue({}) 熔断，原因: {}", key, ex.getMessage());
        log.error(err);
        return CompletableFuture.failedFuture(ex);
    }


}
