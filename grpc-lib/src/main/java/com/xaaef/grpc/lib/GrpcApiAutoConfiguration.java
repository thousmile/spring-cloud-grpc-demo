package com.xaaef.grpc.lib;


import com.xaaef.grpc.lib.interceptor.TokenInterceptor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Slf4j
@Configuration
@AllArgsConstructor
@Import({
        TokenInterceptor.TokenServerInterceptor.class,
        TokenInterceptor.TokenClientInterceptor.class
})
@ComponentScan("com.xaaef.grpc.lib.rpc.impl")
public class GrpcApiAutoConfiguration {

}
