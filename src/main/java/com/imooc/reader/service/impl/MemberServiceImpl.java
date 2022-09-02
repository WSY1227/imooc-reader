package com.imooc.reader.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.reader.entity.Member;
import com.imooc.reader.exception.MemberException;
import com.imooc.reader.service.MemberService;
import com.imooc.reader.mapper.MemberMapper;
import com.imooc.reader.utils.Md5Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.util.resources.LocaleData;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

/**
 * @author xu
 * @description 针对表【member】的数据库操作Service实现
 * @createDate 2022-09-01 18:34:04
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member>
        implements MemberService {
    @Resource
    private MemberMapper memberMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Member createMember(String username, String password, String nickname) {
        QueryWrapper<Member> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        List<Member> members = memberMapper.selectList(wrapper);
        if (members.size() > 0) {
            throw new MemberException("用户已存在");
        }
        Member member = new Member();
        member.setUsername(username);
        member.setNickname(nickname);
        member.setCreateTime(LocalDateTime.now());
        //生成1000-1999的随机数作为盐值
        int salt = new Random().nextInt(1000) + 1000;
        member.setSalt(salt);
        //生成加密后的密码
        String md5 = Md5Utils.md5Digest(password, salt);
        member.setPassword(md5);
        memberMapper.insert(member);
        return member;
    }

    @Override
    public Member checkLogin(String username, String password) {
        QueryWrapper<Member> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        Member member = memberMapper.selectOne(wrapper);
        if (member == null) {
            throw new MemberException("用户不存在");
        }
        String md5Digest = Md5Utils.md5Digest(password, member.getSalt());
        if (!md5Digest.equals(member.getPassword())) {
            throw new MemberException("您输入的密码有误");
        }
        return member;
    }

    @Override
    public Member selectById(Long memberId) {
        return memberMapper.selectById(memberId);
    }
}




