package com.changgou.goods.service.impl;

import com.changgou.goods.dao.SpecMapper;
import com.changgou.goods.pojo.Category;
import com.changgou.goods.pojo.Spec;
import com.changgou.goods.service.CategoryService;
import com.changgou.goods.service.SpecService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecServiceImpl implements SpecService {

    private static final Logger logger = LoggerFactory.getLogger(SpecServiceImpl.class);

    @Autowired
    private SpecMapper specMapper;
    @Autowired
    private CategoryService categoryService;

    @Override
    public PageInfo<Spec> findPage(Spec spec, int page, int size) {
        logger.info("SpecServiceImpl.findPage,{},{},{}",spec.toString(),page,size);
        PageHelper.startPage(page,size);
        List<Spec> list = specMapper.findList(spec);
        return PageInfo.of(list);
    }

    @Override
    public PageInfo<Spec> findPage(int page, int size) {
        logger.info("SpecServiceImpl.findPage,{},{}",page,size);
        PageHelper.startPage(page,size);
        List<Spec> list = specMapper.findAll();
        return PageInfo.of(list);
    }

    @Override
    public List<Spec> findList(Spec spec) {
        logger.info("SpecServiceImpl.findList,{}",spec.toString());
        return specMapper.findList(spec);
    }

    @Override
    public void delete(Integer id) {
        logger.info("SpecServiceImpl.delete,{}",id);
        specMapper.delete(id);
    }

    @Override
    public void update(Spec spec) {
        logger.info("SpecServiceImpl.update,{}",spec.toString());
        specMapper.update(spec);
    }

    @Override
    public void add(Spec spec) {
        logger.info("SpecServiceImpl.add,{}",spec.toString());
        specMapper.add(spec);
    }

    @Override
    public Spec findById(Integer id) {
        logger.info("SpecServiceImpl.findById,{}",id);
        return specMapper.findById(id);
    }

    @Override
    public List<Spec> findAll() {
        logger.info("SpecServiceImpl.findAll");
        return specMapper.findAll();
    }

    /*
     * @Description 通过分类id获取规格参数
     * @Param [categoryId]
     * @Return java.util.List<com.changgou.goods.pojo.Spec>
     * @Date 下午11:15 2021/7/23
     * @Author brick
     **/
    @Override
    public List<Spec> findByCategory(Integer categoryId) {
        Category category = categoryService.findById(categoryId);
        Spec spec = new Spec();
        spec.setTemplateId(category.getTemplateId());
        return specMapper.findList(spec);
    }
}
