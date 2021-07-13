package com.changgou.goods.dao;

import com.changgou.entity.Page;
import com.changgou.goods.pojo.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

// @Mapper
@Repository
public interface BrandMapper{
    public List<Brand> findAll();

    public Brand findById(Integer id);

    public void add(Brand brand);

    public void update(Brand brand);

    public void delete(Integer id);

    public List<Brand> findList(Brand brand);

    Page<Brand> findPage(Map<String, Object> searchMap, int page, int size);
}
