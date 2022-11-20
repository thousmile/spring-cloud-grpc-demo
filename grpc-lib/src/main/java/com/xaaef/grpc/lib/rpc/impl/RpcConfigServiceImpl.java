package com.xaaef.grpc.lib.rpc.impl;


import cn.hutool.core.util.StrUtil;
import com.google.protobuf.Int64Value;
import com.google.protobuf.StringValue;
import com.xaaef.grpc.lib.config.ConfigGrpc;
import com.xaaef.grpc.lib.rpc.RpcConfigService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


@Slf4j
@Service
public class RpcConfigServiceImpl implements RpcConfigService {

    @GrpcClient("grpc-demo1")
    private ConfigGrpc.ConfigBlockingStub blockingStub;


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
        return CompletableFuture
                .completedFuture(
                        blockingStub.getNumberValue(StringValue.of(key)).getValue()
                );
    }


    public CompletableFuture<Long> getNumberValueFallback(String key, Exception ex) {
        var err = StrUtil.format("[grpc] getNumberValue({}) 熔断，原因: {}", key, ex.getMessage());
        log.error(err);
        return CompletableFuture.failedFuture(ex);
    }


}
