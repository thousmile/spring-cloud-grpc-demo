package com.xaaef.grpc.lib.context;

import com.xaaef.grpc.lib.domain.TokenInfo;
import org.springframework.core.NamedInheritableThreadLocal;
import org.springframework.util.StringUtils;

import java.util.Objects;

public class GrpcContext {

    private static final ThreadLocal<String> TENANT_ID = new NamedInheritableThreadLocal<>("TENANT_ID");

    private static final ThreadLocal<TokenInfo> TOKEN_INFO = new NamedInheritableThreadLocal<>("TOKEN_INFO");

    public static void setTenantId(String tenantId) {
        if (StringUtils.hasText(tenantId)) {
            TENANT_ID.set(tenantId);
        } else {
            TENANT_ID.remove();
        }
    }

    public static String getTenantId() {
        return TENANT_ID.get();
    }


    public static void setTokenInfo(TokenInfo tokenInfo) {
        if (Objects.nonNull(tokenInfo)) {
            TOKEN_INFO.set(tokenInfo);
        } else {
            TOKEN_INFO.remove();
        }
    }


    public static TokenInfo getTokenInfo() {
        return TOKEN_INFO.get();
    }

}
