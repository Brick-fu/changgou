package com.changgou.goods.service.impl;

import com.changgou.goods.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    Logger logger = LoggerFactory.getLogger(BrandServiceImpl.class);

    @Override
    public List<Brand> findAll() {
        logger.info("BrandServiceImpl.findAll");
        return brandMapper.findAll();
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.findById(id);
    }

    @Override
    public void add(Brand brand) {
        brandMapper.add(brand);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.update(brand);
    }

    @Override
    public void delete(Integer id) {
        brandMapper.delete(id);
    }

    @Override
    public List<Brand> findList(Map<String, Object> searchMap) {
        return brandMapper.findList(searchMap);
    }
}
