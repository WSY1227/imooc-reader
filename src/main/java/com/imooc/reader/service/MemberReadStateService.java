package com.imooc.reader.service;

import com.imooc.reader.entity.MemberReadState;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author xu
 * @description 针对表【member_read_state】的数据库操作Service
 * @createDate 2022-09-01 17:30:10
 */
public interface MemberReadStateService extends IService<MemberReadState> {
    /**
     * 根据用户id和图书id查询阅读状态
     *
     * @param memberId 会员id
     * @param bookId   图书id
     * @return
     */
    public MemberReadState selectMemberReadState(Long memberId, Long bookId);
}
