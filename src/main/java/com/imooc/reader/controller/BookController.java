package com.imooc.reader.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imooc.reader.utils.ResponseUtils;
import com.imooc.reader.entity.Book;
import com.imooc.reader.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: BookController
 * @Description:
 * @author: XU
 * @date: 2022年09月01日 22:53
 **/
@RestController
@RequestMapping("/api/book")
public class BookController {
    @Resource
    private BookService bookService;

    /**
     * 图书分页查询
     *
     * @param categoryId 分类编号
     * @param order      排序Ge
     * @param page       页号
     * @return
     */
    @GetMapping("/list")
    public ResponseUtils list(Long categoryId, String order, Integer page) {
        ResponseUtils resp = null;
        try {
            IPage<Book> p = bookService.selectPage(categoryId, order, page, 10);
            resp = new ResponseUtils().put("page", p);
        } catch (Exception e) {
            e.printStackTrace();
            new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return resp;
    }

    @GetMapping("/id/{id}")
    public ResponseUtils selectById(@PathVariable Long id) {
        ResponseUtils resp = null;
        try {
            Book book = bookService.selectById(id);
            resp = new ResponseUtils().put("book", book);
        } catch (Exception e) {
            e.printStackTrace();
            new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return resp;
    }
}
