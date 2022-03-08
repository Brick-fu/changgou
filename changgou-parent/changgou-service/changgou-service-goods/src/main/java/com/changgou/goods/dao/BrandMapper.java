package com.changgou.goods.dao;

import com.changgou.common.entity.Page;
import com.changgou.goods.pojo.Brand;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

// @Mapper
@Repository
public interface BrandMapper{
    List<Brand> findAll();

    Brand findById(Integer id);

    void add(Brand brand);

    void update(Brand brand);

    void delete(Integer id);

    List<Brand> findList(Brand brand);

    @Select("SELECT tb.* from tb_brand tb,tb_category_brand tcb WHERE tb.id = tcb.brand_id and tcb.category_id = #{categoryId}")
    List<Brand> findByCategory(Integer categoryId);

    Page<Brand> findPage(Map<String, Object> searchMap, int page, int size);
}
