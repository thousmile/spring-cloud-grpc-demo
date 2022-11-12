package com.xaaef.grpc.server2.rpc;

import com.google.protobuf.BoolValue;
import com.google.protobuf.StringValue;
import com.xaaef.grpc.lib.context.GrpcContext;
import com.xaaef.grpc.lib.greet.GreeterGrpc;
import com.xaaef.grpc.lib.greet.HelloReply;
import com.xaaef.grpc.lib.greet.HelloRequest;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

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


    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        var msg = String.format("Hello grpc-server 2 ==> %s  ==> %s ", request.getName(), UUID.randomUUID());
        var reply = HelloReply.newBuilder().setMessage(msg).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }


    @Override
    public void isChinese(StringValue request, StreamObserver<BoolValue> responseObserver) {
        throw new RuntimeException("自定义异常啊！！！");
    }


}
