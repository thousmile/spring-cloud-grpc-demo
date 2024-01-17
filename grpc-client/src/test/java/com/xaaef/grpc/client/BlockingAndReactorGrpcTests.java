package com.xaaef.grpc.client;


import cn.hutool.core.util.IdUtil;
import com.google.protobuf.StringValue;
import com.xaaef.grpc.lib.context.GrpcContext;
import com.xaaef.grpc.lib.pb.*;
import com.xaaef.grpc.lib.util.ProtobufUtils;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


@Slf4j
@SpringBootTest
public class BlockingAndReactorGrpcTests {

    @GrpcClient(value = "cshap-grpc")
    private ConfigGrpc.ConfigBlockingStub configBlockingStub;

    @GrpcClient("grpc-server")
    private ReactorGreeterGrpc.ReactorGreeterStub reactorGreeterStub;

    @GrpcClient("grpc-server")
    private ReactorConfigGrpc.ReactorConfigStub reactorConfigStub;

    @Test
    public void test1() {
        GrpcContext.randomTokenInfo();
        var d1 = configBlockingStub.getFloatValue(StringValue.of("hello1"));
        System.out.println(d1.getValue());

        var d2 = configBlockingStub.getNumberValue(StringValue.of("hello2"));
        System.out.println(d2.getValue());

        var d3 = configBlockingStub.getStringValue(StringValue.of("hello3"));
        System.out.println(d3.getValue());
    }


    @Test
    public void test2() throws Exception {
        GrpcContext.setTenantId(IdUtil.simpleUUID());
        var latch = new CountDownLatch(10);
        long count = latch.getCount();
        for (int i = 0; i < count; i++) {
            reactorGreeterStub.getUserInfo(Mono.just(StringValue.of("tom " + i)))
                    .timeout(Duration.ofSeconds(1))
                    .doOnError(err -> log.error(err.getMessage()))
                    .onErrorReturn(UserInfo.getDefaultInstance())
                    .subscribe(
                            r -> log.info(ProtobufUtils.toJson(r)),
                            err -> log.error(err.getMessage()),
                            latch::countDown
                    );
        }
        latch.await();
    }


    @Test
    public void test3() throws Exception {
        GrpcContext.randomTokenInfo();
        var latch = new CountDownLatch(10);
        long count = latch.getCount();
        for (int i = 0; i < count; i++) {
            TimeUnit.SECONDS.sleep(1);
            var request = HelloRequest.newBuilder().setName("tom" + i).build();
            reactorGreeterStub.sayHello(Mono.just(request))
                    .timeout(Duration.ofSeconds(1))
                    .map(HelloReply::getMessage)
                    .doOnError(err -> log.error(err.getMessage()))
                    .onErrorReturn("熔断.....")
                    .subscribe(
                            log::info,
                            err -> log.error(err.getMessage()),
                            latch::countDown
                    );
        }
        latch.await();
    }


    @Test
    public void test4() throws Exception {
        GrpcContext.randomTokenInfo();
        var latch = new CountDownLatch(1);
        var request = StringValue.of("tom");
        reactorConfigStub.getStringValue(Mono.just(request))
                .timeout(Duration.ofSeconds(1))
                .map(StringValue::getValue)
                .doOnError(err -> log.error(err.getMessage()))
                .onErrorReturn("熔断.....")
                .subscribe(
                        log::info,
                        err -> log.error(err.getMessage()),
                        latch::countDown
                );
        latch.await();
    }

}
