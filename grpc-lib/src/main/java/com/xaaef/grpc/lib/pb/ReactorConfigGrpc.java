package com.xaaef.grpc.lib.pb;

import static com.xaaef.grpc.lib.pb.ConfigGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: config.proto")
public final class ReactorConfigGrpc {
    private ReactorConfigGrpc() {}

    public static ReactorConfigStub newReactorStub(io.grpc.Channel channel) {
        return new ReactorConfigStub(channel);
    }

    public static final class ReactorConfigStub extends io.grpc.stub.AbstractStub<ReactorConfigStub> {
        private ConfigGrpc.ConfigStub delegateStub;

        private ReactorConfigStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = ConfigGrpc.newStub(channel);
        }

        private ReactorConfigStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = ConfigGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected ReactorConfigStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReactorConfigStub(channel, callOptions);
        }

        public reactor.core.publisher.Mono<com.google.protobuf.StringValue> getStringValue(reactor.core.publisher.Mono<com.google.protobuf.StringValue> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::getStringValue, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.google.protobuf.BoolValue> getBoolValue(reactor.core.publisher.Mono<com.google.protobuf.StringValue> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::getBoolValue, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.google.protobuf.Int64Value> getNumberValue(reactor.core.publisher.Mono<com.google.protobuf.StringValue> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::getNumberValue, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.google.protobuf.DoubleValue> getFloatValue(reactor.core.publisher.Mono<com.google.protobuf.StringValue> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::getFloatValue, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.google.protobuf.Timestamp> getTimestampValue(reactor.core.publisher.Mono<com.google.protobuf.StringValue> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::getTimestampValue, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.google.protobuf.StringValue> getStringValue(com.google.protobuf.StringValue reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::getStringValue, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.google.protobuf.BoolValue> getBoolValue(com.google.protobuf.StringValue reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::getBoolValue, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.google.protobuf.Int64Value> getNumberValue(com.google.protobuf.StringValue reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::getNumberValue, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.google.protobuf.DoubleValue> getFloatValue(com.google.protobuf.StringValue reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::getFloatValue, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.google.protobuf.Timestamp> getTimestampValue(com.google.protobuf.StringValue reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::getTimestampValue, getCallOptions());
        }

    }

    public static abstract class ConfigImplBase implements io.grpc.BindableService {

        public reactor.core.publisher.Mono<com.google.protobuf.StringValue> getStringValue(com.google.protobuf.StringValue request) {
            return getStringValue(reactor.core.publisher.Mono.just(request));
        }

        public reactor.core.publisher.Mono<com.google.protobuf.StringValue> getStringValue(reactor.core.publisher.Mono<com.google.protobuf.StringValue> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public reactor.core.publisher.Mono<com.google.protobuf.BoolValue> getBoolValue(com.google.protobuf.StringValue request) {
            return getBoolValue(reactor.core.publisher.Mono.just(request));
        }

        public reactor.core.publisher.Mono<com.google.protobuf.BoolValue> getBoolValue(reactor.core.publisher.Mono<com.google.protobuf.StringValue> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public reactor.core.publisher.Mono<com.google.protobuf.Int64Value> getNumberValue(com.google.protobuf.StringValue request) {
            return getNumberValue(reactor.core.publisher.Mono.just(request));
        }

        public reactor.core.publisher.Mono<com.google.protobuf.Int64Value> getNumberValue(reactor.core.publisher.Mono<com.google.protobuf.StringValue> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public reactor.core.publisher.Mono<com.google.protobuf.DoubleValue> getFloatValue(com.google.protobuf.StringValue request) {
            return getFloatValue(reactor.core.publisher.Mono.just(request));
        }

        public reactor.core.publisher.Mono<com.google.protobuf.DoubleValue> getFloatValue(reactor.core.publisher.Mono<com.google.protobuf.StringValue> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public reactor.core.publisher.Mono<com.google.protobuf.Timestamp> getTimestampValue(com.google.protobuf.StringValue request) {
            return getTimestampValue(reactor.core.publisher.Mono.just(request));
        }

        public reactor.core.publisher.Mono<com.google.protobuf.Timestamp> getTimestampValue(reactor.core.publisher.Mono<com.google.protobuf.StringValue> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            com.xaaef.grpc.lib.pb.ConfigGrpc.getGetStringValueMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.google.protobuf.StringValue,
                                            com.google.protobuf.StringValue>(
                                            this, METHODID_GET_STRING_VALUE)))
                    .addMethod(
                            com.xaaef.grpc.lib.pb.ConfigGrpc.getGetBoolValueMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.google.protobuf.StringValue,
                                            com.google.protobuf.BoolValue>(
                                            this, METHODID_GET_BOOL_VALUE)))
                    .addMethod(
                            com.xaaef.grpc.lib.pb.ConfigGrpc.getGetNumberValueMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.google.protobuf.StringValue,
                                            com.google.protobuf.Int64Value>(
                                            this, METHODID_GET_NUMBER_VALUE)))
                    .addMethod(
                            com.xaaef.grpc.lib.pb.ConfigGrpc.getGetFloatValueMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.google.protobuf.StringValue,
                                            com.google.protobuf.DoubleValue>(
                                            this, METHODID_GET_FLOAT_VALUE)))
                    .addMethod(
                            com.xaaef.grpc.lib.pb.ConfigGrpc.getGetTimestampValueMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.google.protobuf.StringValue,
                                            com.google.protobuf.Timestamp>(
                                            this, METHODID_GET_TIMESTAMP_VALUE)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

        protected Throwable onErrorMap(Throwable throwable) {
            return com.salesforce.reactorgrpc.stub.ServerCalls.prepareError(throwable);
        }
    }

    public static final int METHODID_GET_STRING_VALUE = 0;
    public static final int METHODID_GET_BOOL_VALUE = 1;
    public static final int METHODID_GET_NUMBER_VALUE = 2;
    public static final int METHODID_GET_FLOAT_VALUE = 3;
    public static final int METHODID_GET_TIMESTAMP_VALUE = 4;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final ConfigImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(ConfigImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_GET_STRING_VALUE:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((com.google.protobuf.StringValue) request,
                            (io.grpc.stub.StreamObserver<com.google.protobuf.StringValue>) responseObserver,
                            serviceImpl::getStringValue, serviceImpl::onErrorMap);
                    break;
                case METHODID_GET_BOOL_VALUE:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((com.google.protobuf.StringValue) request,
                            (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver,
                            serviceImpl::getBoolValue, serviceImpl::onErrorMap);
                    break;
                case METHODID_GET_NUMBER_VALUE:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((com.google.protobuf.StringValue) request,
                            (io.grpc.stub.StreamObserver<com.google.protobuf.Int64Value>) responseObserver,
                            serviceImpl::getNumberValue, serviceImpl::onErrorMap);
                    break;
                case METHODID_GET_FLOAT_VALUE:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((com.google.protobuf.StringValue) request,
                            (io.grpc.stub.StreamObserver<com.google.protobuf.DoubleValue>) responseObserver,
                            serviceImpl::getFloatValue, serviceImpl::onErrorMap);
                    break;
                case METHODID_GET_TIMESTAMP_VALUE:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((com.google.protobuf.StringValue) request,
                            (io.grpc.stub.StreamObserver<com.google.protobuf.Timestamp>) responseObserver,
                            serviceImpl::getTimestampValue, serviceImpl::onErrorMap);
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
