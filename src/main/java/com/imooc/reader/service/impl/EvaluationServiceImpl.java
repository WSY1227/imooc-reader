package com.imooc.reader.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.reader.entity.Evaluation;
import com.imooc.reader.service.EvaluationService;
import com.imooc.reader.mapper.EvaluationMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}




