package com.xaaef.grpc.lib.context;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.google.protobuf.util.Timestamps;
import com.xaaef.grpc.lib.pb.ClientInfo;
import com.xaaef.grpc.lib.pb.GreeterGrpc;
import com.xaaef.grpc.lib.pb.TokenInfo;
import com.xaaef.grpc.lib.pb.UserInfo;
import io.grpc.MethodDescriptor;
import org.springframework.core.NamedInheritableThreadLocal;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


public class GrpcContext {

    private static final NamedInheritableThreadLocal<String> TENANT_ID = new NamedInheritableThreadLocal<>("TENANT_ID");

    private static final NamedInheritableThreadLocal<TokenInfo> TOKEN_INFO = new NamedInheritableThreadLocal<>("TENANT_ID");


    public static void setTenantId(String tenantId) {
        if (StringUtils.hasText(tenantId)) {
            TENANT_ID.set(tenantId);
        } else {
            TENANT_ID.remove();
        }
    }


    public static String getTenantId() {
        return TENANT_ID.get();
    }


    public static void setTokenInfo(TokenInfo tokenInfo) {
        if (Objects.nonNull(tokenInfo)) {
            TOKEN_INFO.set(tokenInfo);
        } else {
            TOKEN_INFO.remove();
        }
    }


    public static TokenInfo getTokenInfo() {
        return TOKEN_INFO.get();
    }


    public static void reset() {
        TENANT_ID.remove();
        TOKEN_INFO.remove();
    }


    // 忽略 认证 的请求方法
    public static final Set<MethodDescriptor<?, ?>> IGNORE_AUTH_METHOD = new HashSet<>() {
        {
            add(GreeterGrpc.getGetUserInfoMethod());
        }
    };


    private final static List<String> ARR = List.of("A", "B", "C", "D", "E", "F", "G", "H", "Q", "W", "Y", "U", "I");


    public static void randomTokenInfo() {
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


}
