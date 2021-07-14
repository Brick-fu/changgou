package com.changgou.goods.service.impl;

import com.changgou.goods.controller.ParaController;
import com.changgou.goods.dao.ParaMapper;
import com.changgou.goods.pojo.Para;
import com.changgou.goods.service.ParaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParaServiceImpl implements ParaService {

    private static Logger logger = LoggerFactory.getLogger(ParaServiceImpl.class);

    @Autowired
    private ParaMapper paraMapper;

    @Override
    public PageInfo<Para> findPage(Para para, int page, int size) {
        logger.info("ParaServiceImpl.findPage,{},{},{}",para.toString(),page,size);
        PageHelper.startPage(page,size);
        List<Para> list = paraMapper.findList(para);
        return PageInfo.of(list);
    }

    @Override
    public PageInfo<Para> findPage(int page, int size) {
        logger.info("ParaServiceImpl.findPage,{},{}",page,size);
        PageHelper.startPage(page,size);
        List<Para> list = paraMapper.findAll();
        return PageInfo.of(list);
    }

    @Override
    public List<Para> findList(Para para) {
        logger.info("ParaServiceImpl.findList,{}",para.toString());
        return paraMapper.findAll();
    }

    @Override
    public void delete(Integer id) {
        logger.info("ParaServiceImpl.delete,{}",id);
        paraMapper.delete(id);
    }

    @Override
    public void update(Para para) {
        logger.info("ParaServiceImpl.update,{}",para.toString());
        paraMapper.update(para);
    }

    @Override
    public void add(Para para) {
        logger.info("ParaServiceImpl.add,{}",para.toString());
        paraMapper.add(para);
    }

    @Override
    public Para findById(Integer id) {
        logger.info("ParaServiceImpl.findById,{}",id);
        return paraMapper.findById(id);
    }

    @Override
    public List<Para> findAll() {
        logger.info("ParaServiceImpl.findAll");
        return paraMapper.findAll();
    }
}
