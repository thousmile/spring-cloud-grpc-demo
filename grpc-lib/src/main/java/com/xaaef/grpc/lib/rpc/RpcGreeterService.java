package com.xaaef.grpc.lib.rpc;

import com.xaaef.grpc.lib.pb.UserInfo;

/**
 * rpc 接口
 */

public interface RpcGreeterService {


    String sayHello(String name);


    UserInfo getUserInfo(String name);


}
