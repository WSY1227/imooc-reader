package com.imooc.reader.config;

import com.fasterxml.jackson.core.json.PackageVersion;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.time.LocalDateTime;

/**
 * @ClassName: CustomObjectMapper
 * @Description: 自定义map类
 * @author: XU
 * @date: 2022年09月02日 14:10
 **/

public class CustomObjectMapper extends ObjectMapper {
    public CustomObjectMapper() {
        this.registerModule(new JavaTimeModule());
    }

    public class JavaTimeModule extends SimpleModule {
        public JavaTimeModule() {
            super(PackageVersion.VERSION);
            this.addSerializer(LocalDateTime.class, new CustomLocalDateTimeSerializer());
        }
    }
}
