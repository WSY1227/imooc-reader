package com.imooc.reader.mapper;

import com.imooc.reader.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author xu
* @description 针对表【book】的数据库操作Mapper
* @createDate 2022-09-01 18:34:04
* @Entity com.imooc.reader.entity.Book
*/
public interface BookMapper extends BaseMapper<Book> {
    public void updateScore();
}




