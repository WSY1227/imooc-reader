package com.imooc.reader.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imooc.reader.entity.Book;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * @author xu
 * @description 针对表【book】的数据库操作Service
 * @createDate 2022-09-01 17:30:10
 */
public interface BookService extends IService<Book> {
    /**
     * 分页查询图书
     *
     * @param categoryId 分类编号
     * @param order      排序方式
     * @param page       页号
     * @param rows       每页记录数
     * @return 分页对象
     */
    public IPage<Book> selectPage(Long categoryId, String order, Integer page, Integer rows);

    /**
     * 根据图书id查询图书对象
     *
     * @param bookId 图书编号
     * @return
     */
    public Book selectById(Long bookId);

    /**
     * 更新图书评分和评论总人数
     */
    public void updateScore();

    /**
     * 联合分类信息的分页查询
     *
     * @param page 当前页
     * @param rows 每页显示多少行
     * @return
     */
    public IPage<Map> selectBookMap(Integer page, Integer rows);

    /**
     * 新增图书
     * @param book
     * @return
     */
    public Book createBook(Book book);
}
