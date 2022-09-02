package com.imooc.reader.controller.management;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imooc.reader.entity.Book;
import com.imooc.reader.service.BookService;
import com.imooc.reader.utils.ResponseUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName: MBookController
 * @Description: 后台book管理
 * @author: XU
 * @date: 2022年09月02日 23:37
 **/
@RestController
@RequestMapping("/api/management/book")
public class MBookController {
    @Resource
    private BookService bookService;

    @GetMapping("/list")
    public ResponseUtils list(Integer page, Integer rows) {
        if (page == null) {
            page = 1;
        }
        if (rows == null) {
            rows = 10;
        }
        ResponseUtils resp = null;
        try {
            IPage<Map> p = bookService.selectBookMap(page, rows);
            resp = new ResponseUtils().put("list", p.getRecords()).put("count", p.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return resp;
    }
}
