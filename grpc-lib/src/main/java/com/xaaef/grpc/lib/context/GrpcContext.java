package com.xaaef.grpc.lib.context;

import com.xaaef.grpc.lib.pb.TokenInfo;
import org.springframework.core.NamedInheritableThreadLocal;
import org.springframework.util.StringUtils;

import java.util.Objects;


public class GrpcContext {

    private static final NamedInheritableThreadLocal<String> TENANT_ID = new NamedInheritableThreadLocal<>("TENANT_ID");

    private static final NamedInheritableThreadLocal<TokenInfo> TOKEN_INFO = new NamedInheritableThreadLocal<>("TENANT_ID");


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


    public static void reset() {
        TENANT_ID.remove();
        TOKEN_INFO.remove();
    }

}
