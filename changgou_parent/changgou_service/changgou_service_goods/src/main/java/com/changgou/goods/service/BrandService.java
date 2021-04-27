package com.changgou.goods.service;

import com.changgou.goods.pojo.Brand;

import java.util.List;
import java.util.Map;

public interface BrandService {
    public List<Brand> findAll();

    public Brand findById(Integer id);

    public void add(Brand brand);

    public void update(Brand brand);

    public void delete(Integer id);

    public List<Brand> findList(Map<String, Object> searchMap);

}
