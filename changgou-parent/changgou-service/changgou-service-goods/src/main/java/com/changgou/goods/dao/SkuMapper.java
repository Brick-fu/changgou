package com.changgou.goods.dao;

import com.changgou.goods.pojo.Sku;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkuMapper {

    /***
     * Sku多条件搜索方法
     * @Skum Sku
     * @return
     */
    List<Sku> findList(Sku sku);

    /***
     * 删除Sku
     * @Skum id
     */
    @Delete("DELETE FROM tb_sku WHERE id  = #{id}")
    void delete(Long id);

    /*
     * @Desc 通过spuId删除sku
     * @Date 下午2:09 2021/7/25
     * @Author 
     **/
    @Delete("DELETE FROM tb_sku WHERE spu_id  = #{spuId}")
    void deleteBySpuId(Long spuId);

    /***
     * 修改Sku数据
     * @Skum Sku
     */
    void update(Sku sku);

    /***
     * 新增Sku
     * @Skum Sku
     */
    @Insert("INSERT INTO tb_sku (id, sn, name, price, num, alert_num, image, images, weight, create_time, update_time, spu_id, category_id, category_name, brand_name, spec, sale_num, comment_num, status) VALUES(#{id},#{sn},#{name},#{price},#{num},#{alertNum},#{image},#{images},#{weight},#{createTime},#{updateTime},#{spuId},#{categoryId},#{categoryName},#{brandName},#{spec},#{saleNum},#{commentNum},#{status})")
    void add(Sku sku);

    /**
     * 根据ID查询Sku
     * @Skum id
     * @return
     */
    @Select("SELECT * from tb_sku WHERE id = #{id}")
    Sku findById(Long id);

    /***
     * 查询所有Sku
     * @return
     */
    @Select("SELECT * from tb_sku")
    List<Sku> findAll();
}
