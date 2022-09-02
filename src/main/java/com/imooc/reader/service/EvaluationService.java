package com.imooc.reader.service;

import com.imooc.reader.entity.Evaluation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * @author xu
 * @description 针对表【evaluation】的数据库操作Service
 * @createDate 2022-09-01 17:30:10
 */
public interface EvaluationService extends IService<Evaluation> {
    /**
     * 根据图书id查询评论和关联评论会员昵称
     *
     * @param bookId 图书id
     * @return
     */
    public List<Map> selectByBookId(Long bookId);

    /**
     * 评论
     *
     * @param memberId 会员id
     * @param bookId   图书id
     * @param score    评分
     * @param content  评论内容
     * @return
     */
    public Evaluation evaluate(Long memberId, Long bookId, Integer score, String content);

    /**
     * 点赞自增1
     *
     * @param evaluationId
     * @return
     */
    public Evaluation enjoy(Long evaluationId);
}
