package com.imooc.reader.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.reader.entity.Test;
import com.imooc.reader.service.TestService;
import com.imooc.reader.mapper.TestMapper;
import org.springframework.stereotype.Service;

/**
* @author xu
* @description 针对表【test】的数据库操作Service实现
* @createDate 2022-09-01 18:34:04
*/
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test>
    implements TestService{

}




