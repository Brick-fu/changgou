package com.changgou.goods.service.impl;

import com.changgou.goods.dao.SkuMapper;
import com.changgou.goods.pojo.Sku;
import com.changgou.goods.service.SkuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    private SkuMapper skuMapper;

    private final Logger logger = LoggerFactory.getLogger(SkuServiceImpl.class);

    /*
     * @Desc 按照条件分页查询sku
     * @Date 下午9:15 2021/7/24
     * @Author 
     **/
    @Override
    public PageInfo<Sku> findPage(Sku sku, int page, int size) {
        logger.info("SkuServiceImpl.findPage,{},{},{}",sku.toString(),page,size);
        PageHelper.startPage(page,size);
        List<Sku> skus = skuMapper.findList(sku);
        return PageInfo.of(skus);
    }

    /*
     * @Desc 分页查询sku
     * @Date 下午9:15 2021/7/24
     * @Author 
     **/
    @Override
    public PageInfo<Sku> findPage(int page, int size) {
        logger.info("SkuServiceImpl.findPage{},{}",page,size);
        PageHelper.startPage(page,size);
        List<Sku> skus = skuMapper.findAll();
        return PageInfo.of(skus);
    }

    /*
     * @Desc 按照条件查询sku
     * @Date 下午9:15 2021/7/24
     * @Author 
     **/
    @Override
    public List<Sku> findList(Sku sku) {
        logger.info("SkuServiceImpl.findList,{}",sku.toString());
        return skuMapper.findList(sku);
    }

    /*
     * @Desc 根据id删除sku
     * @Date 下午9:14 2021/7/24
     * @Author 
     **/
    @Override
    public void delete(Long id) {
        logger.info("SkuServiceImpl.delete,{}",id);
        skuMapper.delete(id);
    }

    /*
     * @Desc 更新sku
     * @Date 下午9:14 2021/7/24
     * @Author 
     **/
    @Override
    public void update(Sku sku) {
        logger.info("SkuServiceImpl.update,{}",sku.toString());
        skuMapper.update(sku);
    }

    /*
     * @Desc 添加sku
     * @Date 下午9:14 2021/7/24
     * @Author 
     **/
    @Override
    public void add(Sku sku) {
        logger.info("SkuServiceImpl.add,{}",sku.toString());
        skuMapper.add(sku);
    }

    /*
     * @Desc 根据id查询sku
     * @Date 下午9:14 2021/7/24
     * @Author 
     **/
    @Override
    public Sku findById(Long id) {
        logger.info("SkuServiceImpl.findById,{}",id);
        return skuMapper.findById(id);
    }

    /*
     * @Desc 查询所有sku
     * @Date 下午9:13 2021/7/24
     * @Author 
     **/
    @Override
    public List<Sku> findAll() {
        logger.info("SkuServiceImpl.findAll");
        return skuMapper.findAll();
    }

    @Override
    public List<Sku> findByStatus(String status) {
        logger.info("SkuServiceImpl.findByStatus,status={}",status);
        return skuMapper.findByStatus(status);
    }
}
