package com.xaaef.grpc.lib;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 用户信息 详情
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
@Accessors(chain = true)
public class LoginUserInfo implements Serializable {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户名称
     */
    private String nickname;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别[ 0.女  1.男  2.未知]
     */
    private Integer gender;

    /**
     * 用户类型，租户用户，系统用户
     */
    private Integer userType;

    /**
     * 所属部门
     */
    private Integer deptId;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 当前用户是不是管理员
     */
    private Integer adminFlag;

    /**
     * 过期时间  为空就是永久
     */
    private Long expired;

}
