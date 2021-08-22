package com.changgou.goods.service.impl;

import com.changgou.goods.dao.TemplateMapper;
import com.changgou.goods.pojo.Template;
import com.changgou.goods.service.TemplateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateMapper templateMapper;

    @Override
    public PageInfo<Template> findPage(Template template, int page, int size) {
        PageHelper.startPage(page,size);
        List<Template> templates = templateMapper.findList(template);
        return PageInfo.of(templates);
    }

    @Override
    public PageInfo<Template> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        List<Template> templates = templateMapper.findAll();
        return PageInfo.of(templates);
    }

    @Override
    public List<Template> findList(Template template) {
        return templateMapper.findList(template);
    }

    @Override
    public void delete(Integer id) {
        templateMapper.delete(id);
    }

    @Override
    public void update(Template template) {
        templateMapper.update(template);
    }

    @Override
    public void add(Template template) {
        templateMapper.add(template);
    }

    @Override
    public Template findById(Integer id) {
        return templateMapper.findById(id);
    }

    @Override
    public List<Template> findAll() {
        return templateMapper.findAll();
    }
}
