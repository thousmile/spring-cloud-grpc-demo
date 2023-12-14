package com.xaaef.grpc.lib;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.JsonFormat;
import com.google.protobuf.util.Timestamps;
import com.xaaef.grpc.lib.pb.ClientInfo;
import com.xaaef.grpc.lib.pb.TokenInfo;
import com.xaaef.grpc.lib.pb.UserInfo;
import com.xaaef.grpc.lib.util.JsonUtils;
import lombok.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;
import java.util.Collection;
import java.util.List;

import static com.xaaef.grpc.lib.util.ProtobufUtils.toBytes;
import static com.xaaef.grpc.lib.util.ProtobufUtils.toPojo;


public class NoSpringTest {

    @Test
    public void test1() {
        var now1 = Instant.now();

        var timestamp = Timestamp.newBuilder()
                .setSeconds(now1.getEpochSecond())
                .setNanos(now1.getNano())
                .build();

        System.out.println(now1);
        System.out.println(timestamp);

        var instant = Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos());
        System.out.println(instant);
    }


    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Employee implements java.io.Serializable {

        public Long id;

        public String name;

        public Integer age;

        public Collection<String> emails;

        public Employee boss;

    }


    @Test
    public void test2() throws IOException {
        var arr = List.of("A", "B", "C", "D", "E", "F", "G", "H", "Q", "W", "Y", "U", "I");

        var empl = Employee.builder()
                .id(IdUtil.getSnowflakeNextId())
                .name(RandomUtil.randomString(12))
                .age(RandomUtil.randomInt(18, 38))
                .emails(RandomUtil.randomEleList(arr, 5))
                .boss(
                        Employee.builder()
                                .id(IdUtil.getSnowflakeNextId())
                                .name(RandomUtil.randomString(16))
                                .age(RandomUtil.randomInt(18, 38))
                                .emails(RandomUtil.randomEleList(arr, 5))
                                .boss(
                                        Employee.builder()
                                                .id(IdUtil.getSnowflakeNextId())
                                                .name(RandomUtil.randomString(16))
                                                .age(RandomUtil.randomInt(18, 38))
                                                .emails(RandomUtil.randomEleList(arr, 5))
                                                .boss(
                                                        Employee.builder()
                                                                .id(IdUtil.getSnowflakeNextId())
                                                                .name(RandomUtil.randomString(16))
                                                                .age(RandomUtil.randomInt(18, 38))
                                                                .emails(RandomUtil.randomEleList(arr, 5))
                                                                .boss(null)
                                                                .build()
                                                )
                                                .build()
                                )
                                .build()
                )
                .build();

        System.out.println(JsonUtils.toFormatJson(empl));

        long start1 = System.currentTimeMillis();
        var protobufData = toBytes(empl);
        long end1 = System.currentTimeMillis() - start1;
        System.out.printf("Writer Protobuf: %d  --->  %d ms%n", protobufData.length, end1);

        System.out.println();
        System.out.println();

        long start2 = System.currentTimeMillis();
        var empl2 = toPojo(protobufData, Employee.class);
        long end2 = System.currentTimeMillis() - start2;
        System.out.printf("ReaderFor Object:  --->  %d ms%n", end2);

        System.out.println(JsonUtils.toFormatJson(empl2));

    }


    @Test
    public void test3() throws InvalidProtocolBufferException {
        var arr = List.of("A", "B", "C", "D", "E", "F", "G", "H", "Q", "W", "Y", "U", "I");

        var empl = TokenInfo.newBuilder()
                .setTokenId(IdUtil.objectId())
                .setTenantId(IdUtil.fastSimpleUUID())
                .setGrantType("sms")
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
                                .addAllGrantTypes(RandomUtil.randomEleList(arr, 5))
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
                .build();

        long start1 = System.currentTimeMillis();
        var protobufData = empl.toByteArray();
        long end1 = System.currentTimeMillis() - start1;
        System.out.printf("Writer Protobuf: %d  --->  %d ms%n", protobufData.length, end1);

        System.out.println();
        System.out.println();

        long start2 = System.currentTimeMillis();
        var empl2 = TokenInfo.parseFrom(protobufData);
        long end2 = System.currentTimeMillis() - start2;
        System.out.printf("ReaderFor Object:  --->  %d ms%n", end2);


        long start3 = System.currentTimeMillis();
        String json = JsonFormat.printer().print(empl2);
        long end3 = System.currentTimeMillis() - start3;
        System.out.printf("Print Json:  --->  %d ms%n", end3);
        System.out.println();
        System.out.println(json);
    }


    @Test
    public void test4() throws Exception {

        var arr = List.of("A", "B", "C", "D", "E", "F", "G", "H", "Q", "W", "Y", "U", "I");

        var empl = TokenValue.builder()
                .tokenId(IdUtil.objectId())
                .tenantId(IdUtil.fastSimpleUUID())
                .grantType("sms")
                .loginClient(
                        ClientDetails.builder()
                                .clientId(RandomUtil.randomString(18))
                                .clientType(1)
                                .tenantId(RandomUtil.randomString(18))
                                .secret(RandomUtil.randomString(32))
                                .name("一二三科技有限公司")
                                .logo(RandomUtil.randomString(36))
                                .description(RandomUtil.randomString(36))
                                .clientType(RandomUtil.randomInt())
                                .grantTypes(RandomUtil.randomEleList(arr, 5))
                                .domainName(RandomUtil.randomString(99))
                                .scope(RandomUtil.randomString(5))
                                .build()
                )
                .loginUser(
                        LoginUserInfo.builder()
                                .userId(RandomUtil.randomLong())
                                .tenantId(RandomUtil.randomString(32))
                                .avatar(RandomUtil.randomString(64))
                                .username(RandomUtil.randomString(12))
                                .mobile(RandomUtil.randomString(11))
                                .email(RandomUtil.randomString(18))
                                .nickname(RandomUtil.randomString(10))
                                .password(RandomUtil.randomString(64))
                                .gender(RandomUtil.randomInt())
                                .userType(RandomUtil.randomInt())
                                .deptId(RandomUtil.randomInt())
                                .status(RandomUtil.randomInt())
                                .adminFlag(RandomUtil.randomInt())
                                .expired(System.currentTimeMillis())
                                .build()
                )
                .loginTime(System.currentTimeMillis())
                .build();


        long start1 = System.currentTimeMillis();
        var protobufData = toBytes(empl);
        long end1 = System.currentTimeMillis() - start1;
        System.out.printf("Writer Protobuf: %d  --->  %d ms%n", protobufData.length, end1);

        System.out.println();
        System.out.println();

        long start2 = System.currentTimeMillis();

        var empl2 = toPojo(protobufData, TokenValue.class);

        long end2 = System.currentTimeMillis() - start2;
        System.out.printf("ReaderFor Object:  --->  %d ms%n", end2);

        System.out.println(JsonUtils.toFormatJson(empl2));

    }


}
