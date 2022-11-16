package com.xaaef.grpc.lib;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 登录成功的客户端，用户信息
 * </p>
 *
 * @author Wang Chen Chen
 * @version 1.0.1
 * @date 2021/7/12 12:08
 */

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenValue implements Serializable {

    /**
     * 全局唯一认证 Id
     */
    private String tokenId;

    private String tenantId;

    /**
     * 认证授权方式
     */
    private String grantType;

    /**
     * 用户信息
     */
    private LoginUserInfo loginUser;

    /**
     * 客户端信息
     */
    private ClientDetails loginClient;

    /**
     * 登录时间
     */
    private Long loginTime;


}
