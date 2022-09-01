package com.imooc.reader.service;

import com.imooc.reader.Test;
import com.imooc.reader.mapper.TestMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName: TestService
 * @Description: service测试
 * @author: XU
 * @date: 2022年09月01日 12:11
 **/
@Service
public class TestService {
    @Resource
    private TestMapper testMapper;

    /*开启事务 将异常回滚扩大到exception*/
    @Transactional(rollbackFor = Exception.class)
    public void batchImport() {
        for (int i = 0; i < 5; i++) {
//            if (i == 2) {
//                throw new RuntimeException("异常");
//            }
            testMapper.insertSample();
        }
    }
}
