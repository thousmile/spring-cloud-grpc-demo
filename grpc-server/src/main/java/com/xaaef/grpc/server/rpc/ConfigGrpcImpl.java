package com.xaaef.grpc.server.rpc;

import com.google.protobuf.*;
import com.xaaef.grpc.lib.pb.ReactorConfigGrpc;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import reactor.core.publisher.Mono;

import java.time.Instant;


@Slf4j
@GrpcService
@AllArgsConstructor
public class ConfigGrpcImpl extends ReactorConfigGrpc.ConfigImplBase {


    @Override
    public Mono<StringValue> getStringValue(Mono<StringValue> request) {
        return request.map(StringValue::getValue)
                .map(data -> StringValue.of(String.format("Hello %s", data)));
    }


    @Override
    public Mono<BoolValue> getBoolValue(Mono<StringValue> request) {
        return request.map(StringValue::getValue)
                .map(data -> BoolValue.of(data.length() / 2 == 0));
    }


    @Override
    public Mono<Int64Value> getNumberValue(Mono<StringValue> request) {
        return request.map(StringValue::getValue)
                .map(data -> Int64Value.of(data.length()));
    }


    @Override
    public Mono<DoubleValue> getFloatValue(Mono<StringValue> request) {
        return request.map(StringValue::getValue)
                .map(data -> DoubleValue.of(data.length()));
    }


    @Override
    public Mono<Timestamp> getTimestampValue(Mono<StringValue> request) {
        return request.map(StringValue::getValue)
                .map(data -> {
                    Instant now = Instant.now();
                    return Timestamp.newBuilder()
                            .setSeconds(now.getEpochSecond())
                            .setNanos(now.getNano())
                            .build();
                });
    }


}
