package com.xaaef.grpc.client;


import com.google.protobuf.DoubleValue;
import com.google.protobuf.StringValue;
import com.xaaef.grpc.lib.pb.ConfigGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CshapGrpcTests {

    @GrpcClient(value = "cshap-grpc")
    private ConfigGrpc.ConfigBlockingStub configBlockingStub;


    @Test
    public void test1() {
        var d1 = configBlockingStub.getFloatValue(StringValue.of("hello1"));
        System.out.println(d1.getValue());

        var d2 = configBlockingStub.getNumberValue(StringValue.of("hello2"));
        System.out.println(d2.getValue());

        var d3 = configBlockingStub.getStringValue(StringValue.of("hello3"));
        System.out.println(d3.getValue());
    }


}
