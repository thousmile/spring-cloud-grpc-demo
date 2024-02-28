package com.xaaef.grpc.lib;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.JsonFormat;
import com.google.protobuf.util.Timestamps;
import com.xaaef.grpc.lib.pb.ClientInfo;
import com.xaaef.grpc.lib.pb.TokenInfo;
import com.xaaef.grpc.lib.pb.UserInfo;
import com.xaaef.grpc.lib.util.ProtobufUtils;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;


public class NoSpringTest {
    static final List<String> arr = List.of("A", "B", "C", "D", "E", "F", "G", "H", "Q", "W", "Y", "U", "I");


    public static TokenInfo.Builder randTokenValue1() {
        return TokenInfo.newBuilder()
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
                );
    }


    public static TokenValue randTokenValue2() {
        return new TokenValue()
                .setTokenId(IdUtil.objectId())
                .setTenantId(IdUtil.fastSimpleUUID())
                .setGrantType("sms")
                .setLoginClient(
                        new ClientDetails()
                                .setClientId(RandomUtil.randomString(18))
                                .setClientType(1)
                                .setTenantId(RandomUtil.randomString(18))
                                .setSecret(RandomUtil.randomString(32))
                                .setName("一二三科技有限公司")
                                .setLogo(RandomUtil.randomString(36))
                                .setDescription(RandomUtil.randomString(36))
                                .setClientType(RandomUtil.randomInt())
                                .setGrantTypes(RandomUtil.randomEleList(arr, 5))
                                .setDomainName(RandomUtil.randomString(99))
                                .setScope(RandomUtil.randomString(5))
                )
                .setLoginUser(
                        new LoginUserInfo()
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
                                .setExpired(System.currentTimeMillis())
                )
                .setLoginTime(System.currentTimeMillis());
    }


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


    @Test
    public void test3() throws Exception {
        var empl = randTokenValue1().build();

        long start1 = System.currentTimeMillis();
        var protobufData = empl.toByteArray();
        long end1 = System.currentTimeMillis() - start1;
        System.out.printf("Writer Protobuf: %d  --->  %d ms%n", protobufData.length, end1);

        System.out.println();

        long start2 = System.currentTimeMillis();
        var empl2 = TokenInfo.parseFrom(protobufData);
        long end2 = System.currentTimeMillis() - start2;
        System.out.printf("ReaderFor Object:  --->  %d ms%n", end2);

        long start3 = System.currentTimeMillis();
        String json = JsonFormat.printer().includingDefaultValueFields().print(empl2);
        long end3 = System.currentTimeMillis() - start3;
        System.out.printf("Print Json:  --->  %d ms%n", end3);
        System.out.println();
        System.out.println(json);
    }


    @Test
    public void test4() throws Exception {
        var empl1 = randTokenValue2();
        ProtobufUtils.getProtobufSchema(empl1.getClass());

        long start1 = System.currentTimeMillis();
        var protobufData = ProtobufUtils.toBytes(empl1);
        long end1 = System.currentTimeMillis() - start1;
        System.out.printf("Writer Protobuf: %d  --->  %d ms%n", protobufData.length, end1);

        System.out.println();

        long start2 = System.currentTimeMillis();
        var empl2 = ProtobufUtils.toPojo(protobufData, TokenValue.class);
        long end2 = System.currentTimeMillis() - start2;
        System.out.printf("ReaderFor Object:  --->  %d ms%n", end2);
    }


    @Test
    public void test5() throws Exception {
        var t1 = randTokenValue1().build();
        var jsonPrinter = JsonFormat.printer()
                .includingDefaultValueFields()
                .printingEnumsAsInts()
                .preservingProtoFieldNames();

        long start2 = System.currentTimeMillis();
        System.out.println(jsonPrinter.print(t1));
        System.out.printf("耗时: %d ms\n", (System.currentTimeMillis() - start2));
        System.out.println();
    }


    @Test
    public void test6() throws Exception {
        var es = Executors.newVirtualThreadPerTaskExecutor();
        var latch = new CountDownLatch(1000);
        long count = latch.getCount();
        for (int i = 0; i < count; i++) {
            int finalI = i;
            es.submit(() -> {
                var thread = Thread.currentThread();
                long id = thread.threadId();
                System.out.printf("Thread: %s  Virtual Thread : %s ->  i : %d\n", id, thread.isVirtual(), finalI);
                latch.countDown();
            });
        }
        latch.await();
    }


    @Test
    public void test7() throws Exception {
        var lc = randTokenValue2().getLoginClient();
        ProtobufUtils.getProtobufSchema(ClientDetails.class);
        long start1 = System.currentTimeMillis();
        byte[] bytes = ProtobufUtils.toBytes(lc);
        System.out.printf("toBytes 耗时: %d ms\n", (System.currentTimeMillis() - start1));
        long start2 = System.currentTimeMillis();
        var clientInfo = ClientInfo.newBuilder()
                .mergeFrom(bytes)
                .build();
        System.out.println(ProtobufUtils.toJson(clientInfo));
        System.out.printf("mergeFrom 耗时: %d ms\n", (System.currentTimeMillis() - start2));
    }


}
