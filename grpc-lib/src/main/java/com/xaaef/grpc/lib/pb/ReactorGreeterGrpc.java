package com.xaaef.grpc.lib.pb;

import static com.xaaef.grpc.lib.pb.GreeterGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: greet.proto")
public final class ReactorGreeterGrpc {
    private ReactorGreeterGrpc() {}

    public static ReactorGreeterStub newReactorStub(io.grpc.Channel channel) {
        return new ReactorGreeterStub(channel);
    }

    public static final class ReactorGreeterStub extends io.grpc.stub.AbstractStub<ReactorGreeterStub> {
        private GreeterGrpc.GreeterStub delegateStub;

        private ReactorGreeterStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = GreeterGrpc.newStub(channel);
        }

        private ReactorGreeterStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = GreeterGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected ReactorGreeterStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReactorGreeterStub(channel, callOptions);
        }

        /**
         * <pre>
         *  Sends a greeting
         * </pre>
         */
        public reactor.core.publisher.Mono<com.xaaef.grpc.lib.pb.HelloReply> sayHello(reactor.core.publisher.Mono<com.xaaef.grpc.lib.pb.HelloRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::sayHello, getCallOptions());
        }

        /**
         * <pre>
         *  Sends a greeting
         * </pre>
         */
        public reactor.core.publisher.Mono<com.xaaef.grpc.lib.pb.UserInfo> getUserInfo(reactor.core.publisher.Mono<com.google.protobuf.StringValue> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::getUserInfo, getCallOptions());
        }

        /**
         * <pre>
         *  Sends a greeting
         * </pre>
         */
        public reactor.core.publisher.Mono<com.xaaef.grpc.lib.pb.HelloReply> sayHello(com.xaaef.grpc.lib.pb.HelloRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::sayHello, getCallOptions());
        }

        /**
         * <pre>
         *  Sends a greeting
         * </pre>
         */
        public reactor.core.publisher.Mono<com.xaaef.grpc.lib.pb.UserInfo> getUserInfo(com.google.protobuf.StringValue reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::getUserInfo, getCallOptions());
        }

    }

    public static abstract class GreeterImplBase implements io.grpc.BindableService {

        /**
         * <pre>
         *  Sends a greeting
         * </pre>
         */
        public reactor.core.publisher.Mono<com.xaaef.grpc.lib.pb.HelloReply> sayHello(com.xaaef.grpc.lib.pb.HelloRequest request) {
            return sayHello(reactor.core.publisher.Mono.just(request));
        }

        /**
         * <pre>
         *  Sends a greeting
         * </pre>
         */
        public reactor.core.publisher.Mono<com.xaaef.grpc.lib.pb.HelloReply> sayHello(reactor.core.publisher.Mono<com.xaaef.grpc.lib.pb.HelloRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  Sends a greeting
         * </pre>
         */
        public reactor.core.publisher.Mono<com.xaaef.grpc.lib.pb.UserInfo> getUserInfo(com.google.protobuf.StringValue request) {
            return getUserInfo(reactor.core.publisher.Mono.just(request));
        }

        /**
         * <pre>
         *  Sends a greeting
         * </pre>
         */
        public reactor.core.publisher.Mono<com.xaaef.grpc.lib.pb.UserInfo> getUserInfo(reactor.core.publisher.Mono<com.google.protobuf.StringValue> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            com.xaaef.grpc.lib.pb.GreeterGrpc.getSayHelloMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.xaaef.grpc.lib.pb.HelloRequest,
                                            com.xaaef.grpc.lib.pb.HelloReply>(
                                            this, METHODID_SAY_HELLO)))
                    .addMethod(
                            com.xaaef.grpc.lib.pb.GreeterGrpc.getGetUserInfoMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.google.protobuf.StringValue,
                                            com.xaaef.grpc.lib.pb.UserInfo>(
                                            this, METHODID_GET_USER_INFO)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

        protected Throwable onErrorMap(Throwable throwable) {
            return com.salesforce.reactorgrpc.stub.ServerCalls.prepareError(throwable);
        }
    }

    public static final int METHODID_SAY_HELLO = 0;
    public static final int METHODID_GET_USER_INFO = 1;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final GreeterImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(GreeterImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_SAY_HELLO:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((com.xaaef.grpc.lib.pb.HelloRequest) request,
                            (io.grpc.stub.StreamObserver<com.xaaef.grpc.lib.pb.HelloReply>) responseObserver,
                            serviceImpl::sayHello, serviceImpl::onErrorMap);
                    break;
                case METHODID_GET_USER_INFO:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((com.google.protobuf.StringValue) request,
                            (io.grpc.stub.StreamObserver<com.xaaef.grpc.lib.pb.UserInfo>) responseObserver,
                            serviceImpl::getUserInfo, serviceImpl::onErrorMap);
                    break;
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }

}
