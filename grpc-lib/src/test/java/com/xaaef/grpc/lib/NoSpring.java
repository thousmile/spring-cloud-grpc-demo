package com.xaaef.grpc.lib;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;
import com.xaaef.grpc.lib.domain.ClientInfo;
import com.xaaef.grpc.lib.domain.TokenInfo;
import com.xaaef.grpc.lib.domain.UserInfo;
import com.xaaef.grpc.lib.util.MsgpackUtils;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;

public class NoSpring {

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
    public void test2() {


    }


    @Test
    public void test3() {

    }


    @Test
    public void test4() {

    }

}
