package com.changgou.goods.service.impl;

import com.changgou.goods.dao.CategoryMapper;
import com.changgou.goods.pojo.Category;
import com.changgou.goods.service.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public PageInfo<Category> findPage(Category category, int page, int size) {
        logger.info("CategoryServiceImpl.findPage,{},{},{}",category.toString(),page,size);
        PageHelper.startPage(page,size);
        List<Category> list = categoryMapper.findList(category);
        return PageInfo.of(list);
    }

    @Override
    public PageInfo<Category> findPage(int page, int size) {
        logger.info("CategoryServiceImpl.findPage,{},{}",page,size);
        PageHelper.startPage(page,size);
        List<Category> list = categoryMapper.findAll();
        return PageInfo.of(list);
    }

    @Override
    public List<Category> findList(Category category) {
        logger.info("CategoryServiceImpl.findPage,{}",category.toString());
        return categoryMapper.findList(category);
    }

    @Override
    public void delete(Integer id) {
        logger.info("CategoryServiceImpl.delete,{}",id);
        categoryMapper.delete(id);
    }

    @Override
    public void update(Category category) {
        logger.info("CategoryServiceImpl.update,{}",category.toString());
        categoryMapper.update(category);
    }

    @Override
    public void add(Category category) {
        logger.info("CategoryServiceImpl.add,{}",category.toString());
        categoryMapper.add(category);
    }

    @Override
    public Category findById(Integer id) {
        logger.info("CategoryServiceImpl.findById,{}",id);
        return categoryMapper.findById(id);
    }

    @Override
    public List<Category> findAll() {
        logger.info("CategoryServiceImpl.findAll");
        return categoryMapper.findAll();
    }

    @Override
    public List<Category> findByParentId(Integer pid) {
        logger.info("CategoryServiceImpl.findByParentId,{}",pid);
        return categoryMapper.findByParentId(pid);
    }
}
