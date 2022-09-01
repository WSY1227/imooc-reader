package com.imooc.reader.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.reader.entity.Category;
import com.imooc.reader.service.CategoryService;
import com.imooc.reader.mapper.CategoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xu
 * @description 针对表【category】的数据库操作Service实现
 * @createDate 2022-09-01 18:34:04
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
        implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> selectAll() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByAsc("category_id");
        return categoryMapper.selectList(queryWrapper);
    }
}




