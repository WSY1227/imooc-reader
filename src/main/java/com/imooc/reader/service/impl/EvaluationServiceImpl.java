package com.imooc.reader.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.reader.entity.Evaluation;
import com.imooc.reader.service.EvaluationService;
import com.imooc.reader.mapper.EvaluationMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author xu
 * @description 针对表【evaluation】的数据库操作Service实现
 * @createDate 2022-09-01 18:34:04
 */
@Service
public class EvaluationServiceImpl extends ServiceImpl<EvaluationMapper, Evaluation>
        implements EvaluationService {
    @Resource
    private EvaluationMapper evaluationMapper;

    @Override
    public List<Map> selectByBookId(Long bookId) {
        List<Map> maps = evaluationMapper.selectByBookId(bookId);
        return maps;
    }

    @Override
    public Evaluation evaluate(Long memberId, Long bookId, Integer score, String content) {
        Evaluation evaluation = new Evaluation();
        evaluation.setMemberId(memberId);
        evaluation.setBookId(bookId);
        evaluation.setScore(score);
        evaluation.setContent(content);
        evaluation.setCreateTime(LocalDateTime.now());
        evaluation.setState("enable");
        evaluation.setEnjoy(0);
        return null;
    }

    @Override
    public Evaluation enjoy(Long evaluationId) {
        Evaluation evaluation = evaluationMapper.selectById(evaluationId);
        evaluation.setEnjoy(evaluation.getEnjoy() + 1);
        evaluationMapper.updateById(evaluation);
        return evaluation;
    }
}




