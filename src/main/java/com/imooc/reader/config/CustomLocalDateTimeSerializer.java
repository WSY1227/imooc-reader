package com.imooc.reader.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @ClassName: CustomLocalDateTimeSerializer
 * @Description: 自定义LocalTime序列化类
 * @author: XU
 * @date: 2022年09月02日 14:05
 **/

public class CustomLocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        long time = localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        jsonGenerator.writeNumber(time);
    }
}
