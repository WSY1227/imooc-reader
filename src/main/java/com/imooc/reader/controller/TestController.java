package com.imooc.reader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TestController
 * @Description: 测试
 * @author: XU
 * @date: 2022年08月31日 23:51
 **/
@RestController
public class TestController {
    @PostMapping("/t/test")
    public Map test1(String content) {
        HashMap hashMap = new HashMap();
        hashMap.put("test", "测试" + content);
        return hashMap;
    }
}
