package com.imooc.reader.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.reader.entity.Book;
import com.imooc.reader.mapper.EvaluationMapper;
import com.imooc.reader.mapper.MemberReadStateMapper;
import com.imooc.reader.service.BookService;
import com.imooc.reader.mapper.BookMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author xu
 * @description 针对表【book】的数据库操作Service实现
 * @createDate 2022-09-01 18:34:04
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
        implements BookService {
    @Resource
    private BookMapper bookMapper;
    @Resource
    private EvaluationMapper evaluationMapper;
    @Resource
    private MemberReadStateMapper memberReadStateMapper;

    @Override
    public IPage<Book> selectPage(Long categoryId, String order, Integer page, Integer rows) {
        IPage<Book> p = new Page<>(page, rows);
        QueryWrapper<Book> wrapper = new QueryWrapper<>();

        if (categoryId != null && categoryId != -1) {
            //为sql添加等于当前categoryId的条件
            wrapper.eq("category_id", categoryId);
        }
        if (order != null) {
            if (order.equals("quantity")) {
                wrapper.orderByDesc("evaluation_quantity");
            } else if (order.equals("score")) {
                wrapper.orderByDesc("evaluation_score");
            }
        } else {
            wrapper.orderByDesc("evaluation_quantity");
        }
        p = bookMapper.selectPage(p, wrapper);
        return p;
    }

    @Override
    public Book selectById(Long bookId) {
        return bookMapper.selectById(bookId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateScore() {
        bookMapper.updateScore();
    }

    @Override
    public IPage<Map> selectBookMap(Integer page, Integer rows) {
        IPage p = new Page(page, rows);

        p = bookMapper.selectBookMap(p);
        return p;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Book createBook(Book book) {
        bookMapper.insert(book);
        return book;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Book updateBook(Book book) {
        bookMapper.updateById(book);
        return book;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Book deleteBook(Long bookId) {
        bookMapper.deleteById(bookId);
        //删除关联表数据
        QueryWrapper wrapper1 = new QueryWrapper();
        wrapper1.eq("book_id", bookId);
        QueryWrapper wrapper2 = new QueryWrapper();
        wrapper2.eq("book_id", bookId);
        evaluationMapper.delete(wrapper1);
        memberReadStateMapper.delete(wrapper2);
        return null;
    }
}




