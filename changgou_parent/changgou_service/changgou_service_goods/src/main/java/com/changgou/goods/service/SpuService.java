package com.changgou.goods.service;

import com.changgou.goods.pojo.Goods;
import com.changgou.goods.pojo.Spu;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SpuService {

    /***
     * 商品上架
     * @param spuId
     */
    void putOnShelves(Long spuId);

    /***
     * 商品下架
     * @param spuId
     */
    void pullOffShelves(Long spuId);

    /***
     * 商品审核
     * @param spuId
     */
    void audit(Long spuId);

    /***
     * 根据SPU的ID查找SPU以及对应的SKU集合
     * @param spuId
     */
    Goods findGoodsById(Long spuId);

    /*
     * @Desc 保存商品
     * @Date 下午10:03 2021/7/24
     * @Author
     **/
    void saveGoods(Goods goods);

    /***
     * Spu多条件分页查询
     * @param spu
     * @param page
     * @param size
     * @return
     */
    PageInfo<Spu> findPage(Spu spu, int page, int size);

    /***
     * Spu分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Spu> findPage(int page, int size);

    /***
     * Spu多条件搜索方法
     * @param spu
     * @return
     */
    List<Spu> findList(Spu spu);

    /***
     * 删除Spu
     * @param id
     */
    void delete(Long id);

    /***
     * 修改Spu数据
     * @param spu
     */
    void update(Spu spu);

    /***
     * 新增Spu
     * @param spu
     */
    void add(Spu spu);

    /**
     * 根据ID查询Spu
     * @param id
     * @return
     */
    Spu findById(Long id);

    /***
     * 查询所有Spu
     * @return
     */
    List<Spu> findAll();

    /*
     * @Desc 批量上架
     * @Date 下午11:24 2021/7/25
     * @Author 
     **/
    int putMany(Long[] ids);

    /*
     * @Desc 批量下架
     * @Date 下午11:37 2021/7/25
     * @Author 
     **/
    int pullMany(Long[] ids);

    /***
     * 逻辑删除
     * @param spuId
     */
    void logicDelete(Long spuId);

    /***
     * 还原被删除商品
     * @param spuId
     */
    void restore(Long spuId);
}
