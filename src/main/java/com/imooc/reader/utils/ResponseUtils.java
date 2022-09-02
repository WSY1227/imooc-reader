package com.imooc.reader.utils;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: ResponseUtils
 * @Description: 统一返回类型
 * @author: XU
 * @date: 2022年09月01日 21:02
 **/
@Data
public class ResponseUtils {
    private String code;
    private String message;
    private Map data = new LinkedHashMap<>();

    public ResponseUtils() {
        this.code = "0";
        this.message = "success";
    }

    public ResponseUtils(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseUtils put(String key, Object value) {
        this.data.put(key, value);
        return this;
    }
}
