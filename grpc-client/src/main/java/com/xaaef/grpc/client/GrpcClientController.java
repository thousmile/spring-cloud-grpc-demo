package com.xaaef.grpc.client;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.JsonFormat;
import com.google.protobuf.util.Timestamps;
import com.xaaef.grpc.lib.context.GrpcContext;
import com.xaaef.grpc.lib.domain.ClientInfo;
import com.xaaef.grpc.lib.domain.TokenInfo;
import com.xaaef.grpc.lib.domain.UserInfo;
import com.xaaef.grpc.lib.rpc.RpcGreeterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;


@Slf4j
@RestController
@AllArgsConstructor
public class GrpcClientController {

    private final RpcGreeterService greeterService;

    private void initToken() {
        GrpcContext.setTenantId(IdUtil.objectId());
        GrpcContext.setTokenInfo(
                TokenInfo.newBuilder()
                        .setTokenId(IdUtil.objectId())
                        .setTenantId(IdUtil.fastSimpleUUID())
                        .setGrantType("sms")
                        .setLoginClient(
                                ClientInfo.newBuilder()
                                        .setClientId(RandomUtil.randomString(10))
                                        .setClientType(1)
                                        .setName("一二三科技有限公司")
                                        .build()
                        )
                        .setLoginUser(
                                UserInfo.newBuilder()
                                        .setUserId(RandomUtil.randomLong())
                                        .setNickname(RandomUtil.randomString(10))
                                        .build()
                        )
                        .setLoginTime(
                                Timestamps.fromMillis(System.currentTimeMillis())
                        )
                        .build()
        );
    }


    @GetMapping("hello")
    public Object hello(@RequestParam String name) {
        initToken();
        log.info("1.hello TenantId: \n{}", GrpcContext.getTenantId());
        var ob= Map.of(
                "msg", greeterService.sayHello(name),
                "date", LocalDate.now(),
                "time", LocalTime.now(),
                "dateTime", LocalDateTime.now()
        );
        log.info("5.hello TenantId: \n{}", GrpcContext.getTenantId());
        return ob;
    }


    @GetMapping("isChinese")
    public String isChinese(@RequestParam String name) {
        initToken();
        return StrUtil.format("{} ===> {}", name, greeterService.isChinese(name));
    }


    @GetMapping("howdy")
    public String howdy(@RequestParam String name) {
        log.info("1.howdy TenantId: \n{}", GrpcContext.getTenantId());
        return greeterService.sayHello(name);
    }


}
