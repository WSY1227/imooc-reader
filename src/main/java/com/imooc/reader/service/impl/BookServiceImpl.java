package com.imooc.reader.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.reader.entity.Book;
import com.imooc.reader.service.BookService;
import com.imooc.reader.mapper.BookMapper;
import org.springframework.stereotype.Service;

/**
* @author xu
* @description 针对表【book】的数据库操作Service实现
* @createDate 2022-09-01 18:34:04
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
    implements BookService{

}




