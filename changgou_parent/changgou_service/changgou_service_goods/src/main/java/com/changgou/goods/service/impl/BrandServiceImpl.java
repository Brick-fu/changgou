package com.changgou.goods.service.impl;

import com.changgou.goods.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    private static final Logger logger = LoggerFactory.getLogger(BrandServiceImpl.class);

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
    public List<Brand> findList(Brand brand) {
        return brandMapper.findList(brand);
    }

    @Override
    public PageInfo<Brand> findPage(Brand brand, int page, int size) {
        PageHelper.startPage(page,size);
        List<Brand> brands;
        if(Objects.isNull(brand)){
            brands = brandMapper.findAll();
        }else{
            brands = brandMapper.findList(brand);
        }
        return new PageInfo<>(brands);
    }
}
