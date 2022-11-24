package com.xaaef.grpc.server.rpc;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.google.protobuf.BoolValue;
import com.google.protobuf.StringValue;
import com.google.protobuf.util.Timestamps;
import com.xaaef.grpc.lib.domain.UserInfo;
import com.xaaef.grpc.lib.greet.GreeterGrpc;
import com.xaaef.grpc.lib.greet.HelloReply;
import com.xaaef.grpc.lib.greet.HelloRequest;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.core.env.Environment;

import java.time.LocalTime;
import java.util.UUID;


/**
 * <p>
 * </p>
 *
 * @author WangChenChen
 * @version 1.0.1
 * @date 2021/11/9 17:03
 */


@Slf4j
@GrpcService
@AllArgsConstructor
public class GreeterGrpcImpl extends GreeterGrpc.GreeterImplBase {

    private final Environment env;

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        /**
         * 通过 GrpcContext 获取 客户端传递的公共参数。
         * var tenantId = GrpcContext.getTenantId();
         * var tokenInfo = GrpcContext.getTokenInfo();
         */
        String port = env.getProperty("server.port");
        var msg = StrUtil.format("Hello grpc-server [{}] ==> {} ==> {}", port, request.getName(), UUID.randomUUID());
        log.info("reply: {}", msg);
        var reply = HelloReply.newBuilder().setMessage(msg).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }


    @Override
    public void getUserInfo(StringValue request, StreamObserver<UserInfo> responseObserver) {
        if (LocalTime.now().getSecond() % 2 == 0) {
            var reply = UserInfo.newBuilder()
                    .setUserId(RandomUtil.randomLong())
                    .setTenantId(RandomUtil.randomString(32))
                    .setAvatar(RandomUtil.randomString(64))
                    .setUsername(request.getValue())
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
                    .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } else {
            throw new RuntimeException("自定义异常！！！");
        }
    }


}
