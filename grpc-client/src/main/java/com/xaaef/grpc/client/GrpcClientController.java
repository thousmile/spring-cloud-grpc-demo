package com.xaaef.grpc.client;

import com.xaaef.grpc.lib.context.GrpcContext;
import com.xaaef.grpc.lib.pb.TokenInfo;
import com.xaaef.grpc.lib.rpc.RpcGreeterService;
import com.xaaef.grpc.lib.util.JsonUtils;
import com.xaaef.grpc.lib.util.ProtobufUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@Slf4j
@RestController
@AllArgsConstructor
public class GrpcClientController {

    private final RpcGreeterService greeterService;

    @GetMapping("hello")
    public Object hello(@RequestParam String name) {
        GrpcContext.randomTokenInfo();
        log.info("1.hello TenantId: \n{}", GrpcContext.getTenantId());
        var result = greeterService.sayHello(name);
        log.info("5.hello TenantId: \n{}", GrpcContext.getTenantId());
        return result;
    }


    @GetMapping("getUserInfo")
    public Map<String, Object> getUserInfo(@RequestParam String name) {
        GrpcContext.randomTokenInfo();
        var val1 = greeterService.getUserInfo(name);
        return JsonUtils.toMap(ProtobufUtils.toJson(val1), String.class, Object.class);
    }


    @GetMapping("getTokenInfo")
    public TokenInfo getTokenInfo() {
        GrpcContext.randomTokenInfo();
        return GrpcContext.getTokenInfo();
    }


    @GetMapping("getLoginUser")
    public LoginUser getLoginUser() {
        GrpcContext.randomTokenInfo();
        return new LoginUser(10498L, "张三", GrpcContext.getTokenInfo());
    }


    @GetMapping("howdy")
    public String howdy(@RequestParam String name) {
        log.info("1.howdy TenantId: \n{}", GrpcContext.getTenantId());
        return greeterService.sayHello(name);
    }


}
