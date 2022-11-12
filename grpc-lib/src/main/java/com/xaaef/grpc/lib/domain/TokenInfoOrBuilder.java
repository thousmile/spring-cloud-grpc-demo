// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: domain.proto

package com.xaaef.grpc.lib.domain;

public interface TokenInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:greet.TokenInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   **
   * 全局唯一认证 Id
   * </pre>
   *
   * <code>string tokenId = 1;</code>
   */
  java.lang.String getTokenId();
  /**
   * <pre>
   **
   * 全局唯一认证 Id
   * </pre>
   *
   * <code>string tokenId = 1;</code>
   */
  com.google.protobuf.ByteString
      getTokenIdBytes();

  /**
   * <pre>
   **
   * 认证授权方式
   * 必须是[ authorization_code | password | client_credentials | tencent_qq | we_chat | sms ]之一！
   * </pre>
   *
   * <code>string grantType = 2;</code>
   */
  java.lang.String getGrantType();
  /**
   * <pre>
   **
   * 认证授权方式
   * 必须是[ authorization_code | password | client_credentials | tencent_qq | we_chat | sms ]之一！
   * </pre>
   *
   * <code>string grantType = 2;</code>
   */
  com.google.protobuf.ByteString
      getGrantTypeBytes();

  /**
   * <pre>
   **
   * 租户ID
   * </pre>
   *
   * <code>string tenantId = 3;</code>
   */
  java.lang.String getTenantId();
  /**
   * <pre>
   **
   * 租户ID
   * </pre>
   *
   * <code>string tenantId = 3;</code>
   */
  com.google.protobuf.ByteString
      getTenantIdBytes();

  /**
   * <pre>
   **
   * 客户端信息
   * </pre>
   *
   * <code>.greet.ClientInfo loginClient = 4;</code>
   */
  boolean hasLoginClient();
  /**
   * <pre>
   **
   * 客户端信息
   * </pre>
   *
   * <code>.greet.ClientInfo loginClient = 4;</code>
   */
  com.xaaef.grpc.lib.domain.ClientInfo getLoginClient();
  /**
   * <pre>
   **
   * 客户端信息
   * </pre>
   *
   * <code>.greet.ClientInfo loginClient = 4;</code>
   */
  com.xaaef.grpc.lib.domain.ClientInfoOrBuilder getLoginClientOrBuilder();

  /**
   * <pre>
   **
   * 用户信息
   * </pre>
   *
   * <code>.greet.UserInfo loginUser = 5;</code>
   */
  boolean hasLoginUser();
  /**
   * <pre>
   **
   * 用户信息
   * </pre>
   *
   * <code>.greet.UserInfo loginUser = 5;</code>
   */
  com.xaaef.grpc.lib.domain.UserInfo getLoginUser();
  /**
   * <pre>
   **
   * 用户信息
   * </pre>
   *
   * <code>.greet.UserInfo loginUser = 5;</code>
   */
  com.xaaef.grpc.lib.domain.UserInfoOrBuilder getLoginUserOrBuilder();

  /**
   * <pre>
   **
   * 登录时间
   * </pre>
   *
   * <code>.google.protobuf.Timestamp loginTime = 6;</code>
   */
  boolean hasLoginTime();
  /**
   * <pre>
   **
   * 登录时间
   * </pre>
   *
   * <code>.google.protobuf.Timestamp loginTime = 6;</code>
   */
  com.google.protobuf.Timestamp getLoginTime();
  /**
   * <pre>
   **
   * 登录时间
   * </pre>
   *
   * <code>.google.protobuf.Timestamp loginTime = 6;</code>
   */
  com.google.protobuf.TimestampOrBuilder getLoginTimeOrBuilder();
}
