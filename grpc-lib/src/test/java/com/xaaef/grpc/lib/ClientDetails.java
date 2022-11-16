package com.xaaef.grpc.lib;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 客户端 详情
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
public class ClientDetails implements Serializable {

    /**
     * 客户端 唯一认证 Id
     */
    private String clientId;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 客户端 密钥
     */
    private String secret;

    /**
     * '客户端名称'
     */
    private String name;

    /**
     * 客户端 图标
     */
    private String logo;

    /**
     * 客户端 描述
     */
    private String description;

    /**
     * 客户端类型 [ 0.第三方应用   1.系统内部应用 ]
     */
    private Integer clientType;

    /**
     * 授权类型 数组格式
     */
    private List<String> grantTypes;

    /**
     * 域名地址，如果是 授权码模式，
     * 必须校验回调地址是否属于此域名之下
     */
    private String domainName;

    /**
     * 授权作用域
     */
    private String scope;

    public boolean containsGrantType(String grantType) {
        if (getGrantTypes() == null || getGrantTypes().size() < 1) {
            return false;
        }
        // 如果 包含 * 。说明拥有所有的认证类型
        if (getGrantTypes().contains("*")) {
            return true;
        }
        // 判断 GrantTypes 是否包含 grantType 认证类型
        if (getGrantTypes().contains(grantType)) {
            return true;
        }
        return false;
    }

}
