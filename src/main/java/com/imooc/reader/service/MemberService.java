package com.imooc.reader.service;

import com.imooc.reader.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author xu
 * @description 针对表【member】的数据库操作Service
 * @createDate 2022-09-01 17:30:10
 */
public interface MemberService extends IService<Member> {
    /**
     * 用户注册方法
     *
     * @param username 用户名
     * @param password 密码
     * @param nickname 昵称
     * @return
     */
    public Member createMember(String username, String password, String nickname);
}
