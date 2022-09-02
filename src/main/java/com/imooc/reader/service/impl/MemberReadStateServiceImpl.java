package com.imooc.reader.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.reader.entity.MemberReadState;
import com.imooc.reader.service.MemberReadStateService;
import com.imooc.reader.mapper.MemberReadStateMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author xu
 * @description 针对表【member_read_state】的数据库操作Service实现
 * @createDate 2022-09-01 18:34:04
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class MemberReadStateServiceImpl extends ServiceImpl<MemberReadStateMapper, MemberReadState>
        implements MemberReadStateService {
    @Resource
    private MemberReadStateMapper memberReadStateMapper;

    @Override
    public MemberReadState selectMemberReadState(Long memberId, Long bookId) {
        QueryWrapper<MemberReadState> wrapper = new QueryWrapper<>();
        wrapper.eq("book_id", bookId);
        wrapper.eq("member_id", memberId);
        MemberReadState memberReadState = memberReadStateMapper.selectOne(wrapper);
        return memberReadState;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public MemberReadState updateMemberReadState(Long memberId, Long bookId, Integer readState) {
        QueryWrapper<MemberReadState> wrapper = new QueryWrapper<>();
        wrapper.eq("book_id", bookId);
        wrapper.eq("member_id", memberId);
        MemberReadState memberReadState = memberReadStateMapper.selectOne(wrapper);
        //查询为空时进行插入
        if (memberReadState == null) {
            memberReadState = new MemberReadState();
            memberReadState.setMemberId(memberId);
            memberReadState.setBookId(bookId);
            memberReadState.setReadState(readState);
            memberReadState.setCreateTime(LocalDateTime.now());
            memberReadStateMapper.insert(memberReadState);
        } else {
            //不为空进行修改更新
            memberReadState.setReadState(readState);
            memberReadState.setCreateTime(LocalDateTime.now());
            memberReadStateMapper.updateById(memberReadState);
        }
        return memberReadState;
    }
}




