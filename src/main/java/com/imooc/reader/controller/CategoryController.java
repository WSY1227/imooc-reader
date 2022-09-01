package com.imooc.reader.controller;

import com.imooc.reader.ResponseUtils;
import com.imooc.reader.entity.Category;
import com.imooc.reader.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: CategoryController
 * @Description: 查询分类数据
 * @author: XU
 * @date: 2022年09月01日 20:59
 **/
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    //查询所有图书分类
    @GetMapping("/list")
    public ResponseUtils list() {
        ResponseUtils resp = null;
        try {
            List<Category> categories = categoryService.selectAll();
            resp = new ResponseUtils().put("list", categories);
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return resp;
    }
}
