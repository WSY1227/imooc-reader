package com.imooc.reader.mapper;

import com.imooc.reader.entity.Evaluation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
* @author xu
* @description 针对表【evaluation】的数据库操作Mapper
* @createDate 2022-09-01 18:34:04
* @Entity com.imooc.reader.entity.Evaluation
*/
public interface EvaluationMapper extends BaseMapper<Evaluation> {
    List<Map> selectByBookId(Long bookId);


}




