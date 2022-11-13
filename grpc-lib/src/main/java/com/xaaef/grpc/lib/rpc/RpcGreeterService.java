package com.xaaef.grpc.lib.rpc;

/**
 * rpc 接口
 */
public interface RpcGreeterService {


    String sayHello(String name);


    boolean isChinese(String name);


}
