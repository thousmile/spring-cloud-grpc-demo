package com.xaaef.grpc.client;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.google.protobuf.util.Timestamps;
import com.xaaef.grpc.lib.context.GrpcContext;
import com.xaaef.grpc.lib.pb.ClientInfo;
import com.xaaef.grpc.lib.pb.TokenInfo;
import com.xaaef.grpc.lib.pb.UserInfo;
import com.xaaef.grpc.lib.rpc.RpcGreeterService;
import com.xaaef.grpc.lib.util.JsonUtils;
import com.xaaef.grpc.lib.util.ProtobufUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@AllArgsConstructor
public class GrpcClientController {

    private final RpcGreeterService greeterService;

    private final static List<String> ARR = List.of("A", "B", "C", "D", "E", "F", "G", "H", "Q", "W", "Y", "U", "I");


    private void initToken() {
        GrpcContext.setTenantId(IdUtil.simpleUUID());
        GrpcContext.setTokenInfo(
                TokenInfo.newBuilder()
                        .setTokenId(IdUtil.objectId())
                        .setTenantId(IdUtil.fastSimpleUUID())
                        .setGrantType("password")
                        .setLoginClient(
                                ClientInfo.newBuilder()
                                        .setClientId(RandomUtil.randomString(18))
                                        .setClientType(1)
                                        .setTenantId(RandomUtil.randomString(18))
                                        .setSecret(RandomUtil.randomString(32))
                                        .setName("一二三科技有限公司")
                                        .setLogo(RandomUtil.randomString(36))
                                        .setDescription(RandomUtil.randomString(36))
                                        .setClientType(RandomUtil.randomInt())
                                        .addAllGrantTypes(RandomUtil.randomEleList(ARR, 5))
                                        .setDomainName(RandomUtil.randomString(99))
                                        .setScope(RandomUtil.randomString(5))
                                        .build()
                        )
                        .setLoginUser(
                                UserInfo.newBuilder()
                                        .setUserId(RandomUtil.randomLong())
                                        .setTenantId(RandomUtil.randomString(32))
                                        .setAvatar(RandomUtil.randomString(64))
                                        .setUsername(RandomUtil.randomString(12))
                                        .setMobile(RandomUtil.randomString(11))
                                        .setEmail(RandomUtil.randomString(18))
                                        .setNickname(RandomUtil.randomString(10))
                                        .setPassword(RandomUtil.randomString(64))
                                        .setGender(RandomUtil.randomInt())
                                        .setUserType(RandomUtil.randomInt())
                                        .setDeptId(RandomUtil.randomInt())
                                        .setStatus(RandomUtil.randomInt())
                                        .setAdminFlag(RandomUtil.randomInt())
                                        .setExpired(Timestamps.fromMillis(System.currentTimeMillis()))
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
        var result = greeterService.sayHello(name);
        log.info("5.hello TenantId: \n{}", GrpcContext.getTenantId());
        return result;
    }


    @GetMapping("getUserInfo")
    public Map<String, Object> getUserInfo(@RequestParam String name) {
        initToken();
        var val1 = greeterService.getUserInfo(name);
        return JsonUtils.toMap(ProtobufUtils.toJson(val1), String.class, Object.class);
    }


    @GetMapping("getTokenInfo")
    public TokenInfo getTokenInfo() {
        initToken();
        return GrpcContext.getTokenInfo();
    }


    @GetMapping("howdy")
    public String howdy(@RequestParam String name) {
        log.info("1.howdy TenantId: \n{}", GrpcContext.getTenantId());
        return greeterService.sayHello(name);
    }


}
