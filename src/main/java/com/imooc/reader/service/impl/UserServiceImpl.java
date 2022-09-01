package com.imooc.reader.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.reader.entity.User;
import com.imooc.reader.service.UserService;
import com.imooc.reader.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author xu
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-09-01 18:34:04
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




