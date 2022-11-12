package com.xaaef.grpc.lib;


import com.xaaef.grpc.lib.interceptor.TokenInterceptor;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.common.circuitbreaker.configuration.CircuitBreakerConfigCustomizer;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.io.IOException;
import java.time.Duration;

import static io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType.TIME_BASED;


@Slf4j
@Configuration
@AllArgsConstructor
@Import({
        TokenInterceptor.TokenServerInterceptor.class,
        TokenInterceptor.TokenClientInterceptor.class
})
public class GrpcApiAutoConfiguration {


    /**
     * 默认 熔断 和 超时
     */
    /*@Bean
    public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
        return factory -> factory.configureDefault(
                id -> new Resilience4JConfigBuilder(id)
                        .timeLimiterConfig(
                                TimeLimiterConfig.custom()
                                        .timeoutDuration(Duration.ofSeconds(3)) // 熔断超时时间
                                        .cancelRunningFuture(true)
                                        .build()
                        )
                        .circuitBreakerConfig(
                                CircuitBreakerConfig.custom()
                                        .slidingWindowType(TIME_BASED)  // 滑动窗口的类型为时间窗口
                                        .slidingWindowSize(60)          // 时间窗口的大小为60秒
                                        .slowCallDurationThreshold(Duration.ofSeconds(3))    // 配置调用执行的时长阈值。当超过这个阈值时，调用会被认为是慢调用，并增加慢调用率。
                                        .minimumNumberOfCalls(5)        // 在单位时间窗口内最少需要5次调用才能开始进行统计计算
                                        .failureRateThreshold(50)       // 在单位时间窗口内调用失败率达到50%后会启动断路器
                                        .enableAutomaticTransitionFromOpenToHalfOpen() // 允许断路器自动由打开状态转换为半开状态
                                        .permittedNumberOfCallsInHalfOpenState(5) // 在半开状态下允许进行正常调用的次数
                                        .waitDurationInOpenState(Duration.ofSeconds(60)) // 断路器打开状态转换为半开状态需要等待60秒
                                        .recordExceptions(RuntimeException.class, IOException.class, Exception.class) // 所有异常都当作失败来处理
                                        .build()
                        ).build()
        );
    }*/

    @Bean
    public CircuitBreakerConfigCustomizer testCustomizer() {
        return CircuitBreakerConfigCustomizer
                .of("sayHello", builder -> builder.slidingWindowSize(100));
    }


}
