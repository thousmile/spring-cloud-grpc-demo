// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: domain.proto

// Protobuf Java Version: 3.25.1
package com.xaaef.grpc.lib.pb;

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
    internal_static_com_xaaef_TokenInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_xaaef_TokenInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_xaaef_UserInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_xaaef_UserInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_xaaef_ClientInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_xaaef_ClientInfo_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014domain.proto\022\tcom.xaaef\032\037google/protob" +
      "uf/timestamp.proto\"\304\001\n\tTokenInfo\022\017\n\007toke" +
      "nId\030\001 \001(\t\022\021\n\tgrantType\030\002 \001(\t\022\020\n\010tenantId" +
      "\030\003 \001(\t\022*\n\013loginClient\030\004 \001(\0132\025.com.xaaef." +
      "ClientInfo\022&\n\tloginUser\030\005 \001(\0132\023.com.xaae" +
      "f.UserInfo\022-\n\tloginTime\030\006 \001(\0132\032.google.p" +
      "rotobuf.Timestamp\"\223\002\n\010UserInfo\022\016\n\006userId" +
      "\030\001 \001(\003\022\020\n\010tenantId\030\002 \001(\t\022\016\n\006avatar\030\003 \001(\t" +
      "\022\020\n\010username\030\004 \001(\t\022\016\n\006mobile\030\005 \001(\t\022\r\n\005em" +
      "ail\030\006 \001(\t\022\020\n\010nickname\030\007 \001(\t\022\020\n\010password\030" +
      "\010 \001(\t\022\016\n\006gender\030\t \001(\005\022\020\n\010userType\030\n \001(\005\022" +
      "\016\n\006deptId\030\013 \001(\003\022\016\n\006status\030\014 \001(\005\022\021\n\tadmin" +
      "Flag\030\r \001(\005\022+\n\007expired\030\016 \001(\0132\032.google.pro" +
      "tobuf.Timestamp\"\274\001\n\nClientInfo\022\020\n\010client" +
      "Id\030\001 \001(\t\022\020\n\010tenantId\030\002 \001(\t\022\016\n\006secret\030\003 \001" +
      "(\t\022\014\n\004name\030\004 \001(\t\022\014\n\004logo\030\005 \001(\t\022\023\n\013descri" +
      "ption\030\006 \001(\t\022\022\n\nclientType\030\007 \001(\005\022\022\n\ngrant" +
      "Types\030\010 \003(\t\022\022\n\ndomainName\030\t \001(\t\022\r\n\005scope" +
      "\030\n \001(\tB5\n\025com.xaaef.grpc.lib.pbP\001Z\013./pb;" +
      "domain\252\002\014GrpcService1P\000b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.TimestampProto.getDescriptor(),
        });
    internal_static_com_xaaef_TokenInfo_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_xaaef_TokenInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_xaaef_TokenInfo_descriptor,
        new java.lang.String[] { "TokenId", "GrantType", "TenantId", "LoginClient", "LoginUser", "LoginTime", });
    internal_static_com_xaaef_UserInfo_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_xaaef_UserInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_xaaef_UserInfo_descriptor,
        new java.lang.String[] { "UserId", "TenantId", "Avatar", "Username", "Mobile", "Email", "Nickname", "Password", "Gender", "UserType", "DeptId", "Status", "AdminFlag", "Expired", });
    internal_static_com_xaaef_ClientInfo_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_xaaef_ClientInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_xaaef_ClientInfo_descriptor,
        new java.lang.String[] { "ClientId", "TenantId", "Secret", "Name", "Logo", "Description", "ClientType", "GrantTypes", "DomainName", "Scope", });
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}