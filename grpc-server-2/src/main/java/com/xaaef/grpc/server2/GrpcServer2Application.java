package com.xaaef.grpc.server2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class GrpcServer2Application {

    public static void main(String[] args) {
        SpringApplication.run(GrpcServer2Application.class, args);
    }

}
