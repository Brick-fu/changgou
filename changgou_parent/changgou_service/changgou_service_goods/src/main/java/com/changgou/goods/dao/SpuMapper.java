package com.changgou.goods.dao;

import com.changgou.goods.pojo.Spu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpuMapper {

    /***
     * Spu多条件搜索方法
     * @Spum Spu
     * @return
     */
    List<Spu> findList(Spu spu);

    /***
     * 删除Spu
     * @Spum id
     */
    void delete(Long id);

    /***
     * 修改Spu数据
     * @Spum Spu
     */
    void update(Spu spu);

    /***
     * 新增Spu
     * @Spum Spu
     */
    void add(Spu spu);

    /**
     * 根据ID查询Spu
     * @Spum id
     * @return
     */
    Spu findById(Long id);

    /***
     * 查询所有Spu
     * @return
     */
    List<Spu> findAll();
    
    /*
     * @Desc 批量上下架
     * @Date 下午11:18 2021/7/25
     * @Author 
     **/

    int batchLoadingAndUnloading(@Param(value = "isMarketable") String isMarketable, @Param(value = "ids") Long[] ids);
}
