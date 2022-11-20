// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: domain.proto

package com.xaaef.grpc.lib.domain;

public interface ClientInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.xaaef.ClientInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   **
   * 客户端 唯一认证 Id
   * </pre>
   *
   * <code>string clientId = 1;</code>
   */
  java.lang.String getClientId();
  /**
   * <pre>
   **
   * 客户端 唯一认证 Id
   * </pre>
   *
   * <code>string clientId = 1;</code>
   */
  com.google.protobuf.ByteString
      getClientIdBytes();

  /**
   * <pre>
   **
   * 租户ID
   * </pre>
   *
   * <code>string tenantId = 2;</code>
   */
  java.lang.String getTenantId();
  /**
   * <pre>
   **
   * 租户ID
   * </pre>
   *
   * <code>string tenantId = 2;</code>
   */
  com.google.protobuf.ByteString
      getTenantIdBytes();

  /**
   * <pre>
   **
   * 客户端 密钥
   * </pre>
   *
   * <code>string secret = 3;</code>
   */
  java.lang.String getSecret();
  /**
   * <pre>
   **
   * 客户端 密钥
   * </pre>
   *
   * <code>string secret = 3;</code>
   */
  com.google.protobuf.ByteString
      getSecretBytes();

  /**
   * <pre>
   **
   * '客户端名称'
   * </pre>
   *
   * <code>string name = 4;</code>
   */
  java.lang.String getName();
  /**
   * <pre>
   **
   * '客户端名称'
   * </pre>
   *
   * <code>string name = 4;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <pre>
   **
   * 客户端 图标
   * </pre>
   *
   * <code>string logo = 5;</code>
   */
  java.lang.String getLogo();
  /**
   * <pre>
   **
   * 客户端 图标
   * </pre>
   *
   * <code>string logo = 5;</code>
   */
  com.google.protobuf.ByteString
      getLogoBytes();

  /**
   * <pre>
   **
   * 客户端 描述
   * </pre>
   *
   * <code>string description = 6;</code>
   */
  java.lang.String getDescription();
  /**
   * <pre>
   **
   * 客户端 描述
   * </pre>
   *
   * <code>string description = 6;</code>
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <pre>
   **
   * 客户端类型 [ 0.第三方应用   1.系统内部应用 ]
   * </pre>
   *
   * <code>int32 clientType = 7;</code>
   */
  int getClientType();

  /**
   * <pre>
   **
   * 授权类型 数组格式
   * 授权类型，必须是[ authorization_code | password | client_credentials | tencent_qq | we_chat | sms ]之一！
   * </pre>
   *
   * <code>repeated string grantTypes = 8;</code>
   */
  java.util.List<java.lang.String>
      getGrantTypesList();
  /**
   * <pre>
   **
   * 授权类型 数组格式
   * 授权类型，必须是[ authorization_code | password | client_credentials | tencent_qq | we_chat | sms ]之一！
   * </pre>
   *
   * <code>repeated string grantTypes = 8;</code>
   */
  int getGrantTypesCount();
  /**
   * <pre>
   **
   * 授权类型 数组格式
   * 授权类型，必须是[ authorization_code | password | client_credentials | tencent_qq | we_chat | sms ]之一！
   * </pre>
   *
   * <code>repeated string grantTypes = 8;</code>
   */
  java.lang.String getGrantTypes(int index);
  /**
   * <pre>
   **
   * 授权类型 数组格式
   * 授权类型，必须是[ authorization_code | password | client_credentials | tencent_qq | we_chat | sms ]之一！
   * </pre>
   *
   * <code>repeated string grantTypes = 8;</code>
   */
  com.google.protobuf.ByteString
      getGrantTypesBytes(int index);

  /**
   * <pre>
   **
   * 域名地址，如果是 授权码模式， 必须校验回调地址是否属于此域名之下
   * </pre>
   *
   * <code>string domainName = 9;</code>
   */
  java.lang.String getDomainName();
  /**
   * <pre>
   **
   * 域名地址，如果是 授权码模式， 必须校验回调地址是否属于此域名之下
   * </pre>
   *
   * <code>string domainName = 9;</code>
   */
  com.google.protobuf.ByteString
      getDomainNameBytes();

  /**
   * <pre>
   **
   * 授权作用域
   * </pre>
   *
   * <code>string scope = 10;</code>
   */
  java.lang.String getScope();
  /**
   * <pre>
   **
   * 授权作用域
   * </pre>
   *
   * <code>string scope = 10;</code>
   */
  com.google.protobuf.ByteString
      getScopeBytes();
}
