package com.xaaef.grpc.lib.util;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.protobuf.ProtobufMapper;
import com.fasterxml.jackson.dataformat.protobuf.schemagen.ProtobufSchemaGenerator;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.util.JsonFormat;
import lombok.extern.slf4j.Slf4j;


/**
 * <p>
 * Protobuf 工具类
 * </p>
 *
 * @author Wang Chen Chen <932560435@qq.com>
 * @version 2.0
 * @date 2019/4/18 11:45
 */


@Slf4j
public class ProtobufUtils {

    private static final ProtobufMapper MAPPER = new ProtobufMapper();

    private static final JsonFormat.Printer JSON_PRINTER = JsonFormat.printer().includingDefaultValueFields();

    private static final JsonFormat.Parser JSON_PARSER = JsonFormat.parser();

    static {
        MAPPER.registerModules(new Jdk8Module(), new JavaTimeModule())
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true)
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }


    public static ProtobufMapper getMapper() {
        return MAPPER;
    }


    public static String toJson(MessageOrBuilder message) {
        try {
            return JSON_PRINTER.print(message);
        } catch (InvalidProtocolBufferException e) {
            log.error(e.getMessage());
        }
        return StrUtil.EMPTY;
    }


    public static void jsonMergeMessage(String json, Message.Builder builder) {
        try {
            JSON_PARSER.merge(json, builder);
        } catch (InvalidProtocolBufferException e) {
            log.error(e.getMessage());
        }
    }


    /**
     * 将 对象 转换成 二进制
     */
    public static byte[] toBytes(Object data) {
        try {
            var gen = new ProtobufSchemaGenerator();
            MAPPER.acceptJsonFormatVisitor(data.getClass(), gen);
            var schema = gen.getGeneratedSchema();
            return MAPPER.writer(schema).writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        return new byte[0];
    }


    /**
     * 将 二进制 结果集转化为对象
     */
    public static <T> T toPojo(byte[] data, Class<T> beanType) {
        try {
            var gen = new ProtobufSchemaGenerator();
            MAPPER.acceptJsonFormatVisitor(beanType, gen);
            var schema = gen.getGeneratedSchema();
            return MAPPER.readerFor(beanType).with(schema).readValue(data);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }


}
