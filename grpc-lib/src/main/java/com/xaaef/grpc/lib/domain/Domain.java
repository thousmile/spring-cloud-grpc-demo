// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: domain.proto

package com.xaaef.grpc.lib.domain;

public final class Domain {
  private Domain() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_greet_TokenInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_greet_TokenInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_greet_UserInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_greet_UserInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_greet_ClientInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_greet_ClientInfo_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014domain.proto\022\005greet\032\037google/protobuf/t" +
      "imestamp.proto\"\274\001\n\tTokenInfo\022\017\n\007tokenId\030" +
      "\001 \001(\t\022\021\n\tgrantType\030\002 \001(\t\022\020\n\010tenantId\030\003 \001" +
      "(\t\022&\n\013loginClient\030\004 \001(\0132\021.greet.ClientIn" +
      "fo\022\"\n\tloginUser\030\005 \001(\0132\017.greet.UserInfo\022-" +
      "\n\tloginTime\030\006 \001(\0132\032.google.protobuf.Time" +
      "stamp\"\223\002\n\010UserInfo\022\016\n\006userId\030\001 \001(\003\022\020\n\010te" +
      "nantId\030\002 \001(\t\022\016\n\006avatar\030\003 \001(\t\022\020\n\010username" +
      "\030\004 \001(\t\022\016\n\006mobile\030\005 \001(\t\022\r\n\005email\030\006 \001(\t\022\020\n" +
      "\010nickname\030\007 \001(\t\022\020\n\010password\030\010 \001(\t\022\016\n\006gen" +
      "der\030\t \001(\005\022\020\n\010userType\030\n \001(\005\022\016\n\006deptId\030\013 " +
      "\001(\003\022\016\n\006status\030\014 \001(\005\022\021\n\tadminFlag\030\r \001(\005\022+" +
      "\n\007expired\030\016 \001(\0132\032.google.protobuf.Timest" +
      "amp\"\274\001\n\nClientInfo\022\020\n\010clientId\030\001 \001(\t\022\020\n\010" +
      "tenantId\030\002 \001(\t\022\016\n\006secret\030\003 \001(\t\022\014\n\004name\030\004" +
      " \001(\t\022\014\n\004logo\030\005 \001(\t\022\023\n\013description\030\006 \001(\t\022" +
      "\022\n\nclientType\030\007 \001(\005\022\022\n\ngrantTypes\030\010 \003(\t\022" +
      "\022\n\ndomainName\030\t \001(\t\022\r\n\005scope\030\n \001(\tB7\n\031co" +
      "m.xaaef.grpc.lib.domainP\001Z\t.;message\252\002\014G" +
      "rpcService1P\000b\006proto3"
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
        }, assigner);
    internal_static_greet_TokenInfo_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_greet_TokenInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_greet_TokenInfo_descriptor,
        new java.lang.String[] { "TokenId", "GrantType", "TenantId", "LoginClient", "LoginUser", "LoginTime", });
    internal_static_greet_UserInfo_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_greet_UserInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_greet_UserInfo_descriptor,
        new java.lang.String[] { "UserId", "TenantId", "Avatar", "Username", "Mobile", "Email", "Nickname", "Password", "Gender", "UserType", "DeptId", "Status", "AdminFlag", "Expired", });
    internal_static_greet_ClientInfo_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_greet_ClientInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_greet_ClientInfo_descriptor,
        new java.lang.String[] { "ClientId", "TenantId", "Secret", "Name", "Logo", "Description", "ClientType", "GrantTypes", "DomainName", "Scope", });
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}