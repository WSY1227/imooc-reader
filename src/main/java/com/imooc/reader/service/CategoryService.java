package com.imooc.reader.service;

import com.imooc.reader.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author xu
 * @description 针对表【category】的数据库操作Service
 * @createDate 2022-09-01 17:30:10
 */
public interface CategoryService extends IService<Category> {
    public List<Category> selectAll();
}
