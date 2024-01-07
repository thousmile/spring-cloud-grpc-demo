package com.xaaef.grpc.client;

import com.google.protobuf.StringValue;
import com.xaaef.grpc.lib.pb.GreeterGrpc;
import com.xaaef.grpc.lib.pb.UserInfo;
import io.grpc.MethodDescriptor;
import io.grpc.ServiceDescriptor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Collection;


@Slf4j
public class NoSpringTests {

    @Test
    public void test1() {
        MethodDescriptor<StringValue, UserInfo> getUserInfoMethod = GreeterGrpc.getGetUserInfoMethod();
        ServiceDescriptor serviceDescriptor = GreeterGrpc.getServiceDescriptor();
        MethodDescriptor<?,?> getUserInfoMethod1 = GreeterGrpc.getGetUserInfoMethod();
        Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    }

}
