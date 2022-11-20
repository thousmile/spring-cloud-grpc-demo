package com.xaaef.grpc.lib.rpc;

import java.util.concurrent.Future;

/**
 * rpc 接口
 */

public interface RpcConfigService {

    String getStringValue(String key);

    Boolean getBoolValue(String key);

    Future<Long> getNumberValue(String key);

}
