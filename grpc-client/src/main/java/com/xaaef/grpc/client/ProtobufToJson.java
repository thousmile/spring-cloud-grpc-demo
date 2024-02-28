package com.xaaef.grpc.client;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.protobuf.Message;
import com.xaaef.grpc.lib.util.ProtobufUtils;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * <p>
 * 将 com.google.protobuf.Message 转 json
 * </p>
 *
 * @author WangChenChen
 * @version 1.0.0
 * @date 2024/1/5 17:11
 */


public class ProtobufToJson {

    @JsonComponent
    @JsonSerialize
    public static class MessageJsonSerializer extends com.fasterxml.jackson.databind.JsonSerializer<Message> {
        @Override
        public void serialize(Message value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            var jsonValue = ProtobufUtils.toJson(value);
            gen.writeRawValue(jsonValue);
        }
    }

}
