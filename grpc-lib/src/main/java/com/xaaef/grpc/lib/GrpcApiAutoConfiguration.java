package com.xaaef.grpc.lib;


import com.xaaef.grpc.lib.interceptor.GlobalTokenClientInterceptor;
import com.xaaef.grpc.lib.interceptor.GlobalTokenServerInterceptor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * <p>
 * Grpc 自定配置类
 * </p>
 *
 * @author WangChenChen
 * @version 1.1
 * @date 2022/11/19 15:10
 */


@Slf4j
@Configuration
@AllArgsConstructor
@Import({
        GlobalTokenServerInterceptor.class,
        GlobalTokenClientInterceptor.class
})
@ComponentScan("com.xaaef.grpc.lib.rpc.impl")
public class GrpcApiAutoConfiguration {


}
