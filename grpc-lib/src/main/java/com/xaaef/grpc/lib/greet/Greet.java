// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: greet.proto

package com.xaaef.grpc.lib.greet;

public final class Greet {
  private Greet() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_greet_HelloRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_greet_HelloRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_greet_HelloReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_greet_HelloReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013greet.proto\022\005greet\032\037google/protobuf/ti" +
      "mestamp.proto\032\036google/protobuf/wrappers." +
      "proto\032\014domain.proto\"\034\n\014HelloRequest\022\014\n\004n" +
      "ame\030\001 \001(\t\"\035\n\nHelloReply\022\017\n\007message\030\001 \001(\t" +
      "2{\n\007Greeter\0222\n\010SayHello\022\023.greet.HelloReq" +
      "uest\032\021.greet.HelloReply\022<\n\013GetUserInfo\022\034" +
      ".google.protobuf.StringValue\032\017.greet.Use" +
      "rInfoB6\n\030com.xaaef.grpc.lib.greetP\001Z\t.;m" +
      "essage\252\002\014GrpcService1P\000P\001P\002b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.TimestampProto.getDescriptor(),
          com.google.protobuf.WrappersProto.getDescriptor(),
          com.xaaef.grpc.lib.domain.Domain.getDescriptor(),
        }, assigner);
    internal_static_greet_HelloRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_greet_HelloRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_greet_HelloRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_greet_HelloReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_greet_HelloReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_greet_HelloReply_descriptor,
        new java.lang.String[] { "Message", });
    com.google.protobuf.TimestampProto.getDescriptor();
    com.google.protobuf.WrappersProto.getDescriptor();
    com.xaaef.grpc.lib.domain.Domain.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
