package com.xaaef.grpc.client;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
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


@JsonComponent
public class MessageJsonSerializer extends JsonSerializer<Message> {

    @Override
    public void serialize(Message message, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        var json = ProtobufUtils.toJson(message);
        jsonGenerator.writeRawValue(json);
    }


}
