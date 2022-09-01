package com.imooc.reader.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.reader.entity.Member;
import com.imooc.reader.service.MemberService;
import com.imooc.reader.mapper.MemberMapper;
import org.springframework.stereotype.Service;

/**
* @author xu
* @description 针对表【member】的数据库操作Service实现
* @createDate 2022-09-01 18:34:04
*/
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member>
    implements MemberService{

}




