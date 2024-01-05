package com.xaaef.grpc.lib.pb;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.60.1)",
    comments = "Source: config.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ConfigGrpc {

  private ConfigGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.xaaef.Config";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.google.protobuf.StringValue> getGetStringValueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStringValue",
      requestType = com.google.protobuf.StringValue.class,
      responseType = com.google.protobuf.StringValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.google.protobuf.StringValue> getGetStringValueMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, com.google.protobuf.StringValue> getGetStringValueMethod;
    if ((getGetStringValueMethod = ConfigGrpc.getGetStringValueMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getGetStringValueMethod = ConfigGrpc.getGetStringValueMethod) == null) {
          ConfigGrpc.getGetStringValueMethod = getGetStringValueMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, com.google.protobuf.StringValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStringValue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("GetStringValue"))
              .build();
        }
      }
    }
    return getGetStringValueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.google.protobuf.BoolValue> getGetBoolValueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBoolValue",
      requestType = com.google.protobuf.StringValue.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.google.protobuf.BoolValue> getGetBoolValueMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, com.google.protobuf.BoolValue> getGetBoolValueMethod;
    if ((getGetBoolValueMethod = ConfigGrpc.getGetBoolValueMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getGetBoolValueMethod = ConfigGrpc.getGetBoolValueMethod) == null) {
          ConfigGrpc.getGetBoolValueMethod = getGetBoolValueMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBoolValue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("GetBoolValue"))
              .build();
        }
      }
    }
    return getGetBoolValueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.google.protobuf.Int64Value> getGetNumberValueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNumberValue",
      requestType = com.google.protobuf.StringValue.class,
      responseType = com.google.protobuf.Int64Value.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.google.protobuf.Int64Value> getGetNumberValueMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, com.google.protobuf.Int64Value> getGetNumberValueMethod;
    if ((getGetNumberValueMethod = ConfigGrpc.getGetNumberValueMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getGetNumberValueMethod = ConfigGrpc.getGetNumberValueMethod) == null) {
          ConfigGrpc.getGetNumberValueMethod = getGetNumberValueMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, com.google.protobuf.Int64Value>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNumberValue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Int64Value.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("GetNumberValue"))
              .build();
        }
      }
    }
    return getGetNumberValueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.google.protobuf.DoubleValue> getGetFloatValueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFloatValue",
      requestType = com.google.protobuf.StringValue.class,
      responseType = com.google.protobuf.DoubleValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.google.protobuf.DoubleValue> getGetFloatValueMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, com.google.protobuf.DoubleValue> getGetFloatValueMethod;
    if ((getGetFloatValueMethod = ConfigGrpc.getGetFloatValueMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getGetFloatValueMethod = ConfigGrpc.getGetFloatValueMethod) == null) {
          ConfigGrpc.getGetFloatValueMethod = getGetFloatValueMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, com.google.protobuf.DoubleValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFloatValue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.DoubleValue.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("GetFloatValue"))
              .build();
        }
      }
    }
    return getGetFloatValueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.google.protobuf.Timestamp> getGetTimestampValueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTimestampValue",
      requestType = com.google.protobuf.StringValue.class,
      responseType = com.google.protobuf.Timestamp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.google.protobuf.Timestamp> getGetTimestampValueMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, com.google.protobuf.Timestamp> getGetTimestampValueMethod;
    if ((getGetTimestampValueMethod = ConfigGrpc.getGetTimestampValueMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getGetTimestampValueMethod = ConfigGrpc.getGetTimestampValueMethod) == null) {
          ConfigGrpc.getGetTimestampValueMethod = getGetTimestampValueMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, com.google.protobuf.Timestamp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTimestampValue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Timestamp.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("GetTimestampValue"))
              .build();
        }
      }
    }
    return getGetTimestampValueMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ConfigStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConfigStub>() {
        @java.lang.Override
        public ConfigStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConfigStub(channel, callOptions);
        }
      };
    return ConfigStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConfigBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConfigBlockingStub>() {
        @java.lang.Override
        public ConfigBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConfigBlockingStub(channel, callOptions);
        }
      };
    return ConfigBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ConfigFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConfigFutureStub>() {
        @java.lang.Override
        public ConfigFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConfigFutureStub(channel, callOptions);
        }
      };
    return ConfigFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getStringValue(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetStringValueMethod(), responseObserver);
    }

    /**
     */
    default void getBoolValue(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBoolValueMethod(), responseObserver);
    }

    /**
     */
    default void getNumberValue(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Int64Value> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNumberValueMethod(), responseObserver);
    }

    /**
     */
    default void getFloatValue(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.DoubleValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFloatValueMethod(), responseObserver);
    }

    /**
     */
    default void getTimestampValue(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Timestamp> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTimestampValueMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Config.
   */
  public static abstract class ConfigImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ConfigGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Config.
   */
  public static final class ConfigStub
      extends io.grpc.stub.AbstractAsyncStub<ConfigStub> {
    private ConfigStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigStub(channel, callOptions);
    }

    /**
     */
    public void getStringValue(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStringValueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBoolValue(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBoolValueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getNumberValue(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Int64Value> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNumberValueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getFloatValue(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.DoubleValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFloatValueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTimestampValue(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Timestamp> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTimestampValueMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Config.
   */
  public static final class ConfigBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ConfigBlockingStub> {
    private ConfigBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.StringValue getStringValue(com.google.protobuf.StringValue request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStringValueMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue getBoolValue(com.google.protobuf.StringValue request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBoolValueMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Int64Value getNumberValue(com.google.protobuf.StringValue request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNumberValueMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.DoubleValue getFloatValue(com.google.protobuf.StringValue request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFloatValueMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Timestamp getTimestampValue(com.google.protobuf.StringValue request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTimestampValueMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Config.
   */
  public static final class ConfigFutureStub
      extends io.grpc.stub.AbstractFutureStub<ConfigFutureStub> {
    private ConfigFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.StringValue> getStringValue(
        com.google.protobuf.StringValue request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStringValueMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> getBoolValue(
        com.google.protobuf.StringValue request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBoolValueMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Int64Value> getNumberValue(
        com.google.protobuf.StringValue request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNumberValueMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.DoubleValue> getFloatValue(
        com.google.protobuf.StringValue request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFloatValueMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Timestamp> getTimestampValue(
        com.google.protobuf.StringValue request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTimestampValueMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_STRING_VALUE = 0;
  private static final int METHODID_GET_BOOL_VALUE = 1;
  private static final int METHODID_GET_NUMBER_VALUE = 2;
  private static final int METHODID_GET_FLOAT_VALUE = 3;
  private static final int METHODID_GET_TIMESTAMP_VALUE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STRING_VALUE:
          serviceImpl.getStringValue((com.google.protobuf.StringValue) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.StringValue>) responseObserver);
          break;
        case METHODID_GET_BOOL_VALUE:
          serviceImpl.getBoolValue((com.google.protobuf.StringValue) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
          break;
        case METHODID_GET_NUMBER_VALUE:
          serviceImpl.getNumberValue((com.google.protobuf.StringValue) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Int64Value>) responseObserver);
          break;
        case METHODID_GET_FLOAT_VALUE:
          serviceImpl.getFloatValue((com.google.protobuf.StringValue) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.DoubleValue>) responseObserver);
          break;
        case METHODID_GET_TIMESTAMP_VALUE:
          serviceImpl.getTimestampValue((com.google.protobuf.StringValue) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Timestamp>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetStringValueMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.StringValue,
              com.google.protobuf.StringValue>(
                service, METHODID_GET_STRING_VALUE)))
        .addMethod(
          getGetBoolValueMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.StringValue,
              com.google.protobuf.BoolValue>(
                service, METHODID_GET_BOOL_VALUE)))
        .addMethod(
          getGetNumberValueMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.StringValue,
              com.google.protobuf.Int64Value>(
                service, METHODID_GET_NUMBER_VALUE)))
        .addMethod(
          getGetFloatValueMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.StringValue,
              com.google.protobuf.DoubleValue>(
                service, METHODID_GET_FLOAT_VALUE)))
        .addMethod(
          getGetTimestampValueMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.StringValue,
              com.google.protobuf.Timestamp>(
                service, METHODID_GET_TIMESTAMP_VALUE)))
        .build();
  }

  private static abstract class ConfigBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConfigBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.xaaef.grpc.lib.pb.ConfigOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Config");
    }
  }

  private static final class ConfigFileDescriptorSupplier
      extends ConfigBaseDescriptorSupplier {
    ConfigFileDescriptorSupplier() {}
  }

  private static final class ConfigMethodDescriptorSupplier
      extends ConfigBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ConfigMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ConfigGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ConfigFileDescriptorSupplier())
              .addMethod(getGetStringValueMethod())
              .addMethod(getGetBoolValueMethod())
              .addMethod(getGetNumberValueMethod())
              .addMethod(getGetFloatValueMethod())
              .addMethod(getGetTimestampValueMethod())
              .build();
        }
      }
    }
    return result;
  }
}
