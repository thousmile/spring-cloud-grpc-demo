// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: config.proto

// Protobuf Java Version: 3.25.3
package com.xaaef.grpc.lib.pb;

public final class ConfigOuterClass {
  private ConfigOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014config.proto\022\tcom.xaaef\032\037google/protob" +
      "uf/timestamp.proto\032\036google/protobuf/wrap" +
      "pers.proto2\211\003\n\006Config\022L\n\016GetStringValue\022" +
      "\034.google.protobuf.StringValue\032\034.google.p" +
      "rotobuf.StringValue\022H\n\014GetBoolValue\022\034.go" +
      "ogle.protobuf.StringValue\032\032.google.proto" +
      "buf.BoolValue\022K\n\016GetNumberValue\022\034.google" +
      ".protobuf.StringValue\032\033.google.protobuf." +
      "Int64Value\022K\n\rGetFloatValue\022\034.google.pro" +
      "tobuf.StringValue\032\034.google.protobuf.Doub" +
      "leValue\022M\n\021GetTimestampValue\022\034.google.pr" +
      "otobuf.StringValue\032\032.google.protobuf.Tim" +
      "estampB5\n\025com.xaaef.grpc.lib.pbP\001Z\013./pb;" +
      "config\252\002\014GrpcService1P\000P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.TimestampProto.getDescriptor(),
          com.google.protobuf.WrappersProto.getDescriptor(),
        });
    com.google.protobuf.TimestampProto.getDescriptor();
    com.google.protobuf.WrappersProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
