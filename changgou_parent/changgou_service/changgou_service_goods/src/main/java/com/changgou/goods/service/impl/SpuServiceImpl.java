package com.changgou.goods.service.impl;

import com.alibaba.fastjson.JSON;
import com.changgou.goods.dao.SkuMapper;
import com.changgou.goods.dao.SpuMapper;
import com.changgou.goods.pojo.*;
import com.changgou.goods.service.BrandService;
import com.changgou.goods.service.CategoryService;
import com.changgou.goods.service.SpuService;
import com.changgou.utils.IdWorker;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private SpuMapper spuMapper;
    @Autowired
    private SkuMapper skuMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BrandService brandService;

    private final Logger logger = LoggerFactory.getLogger(SpuServiceImpl.class);

    @Override
    public void saveGoods(Goods goods) {
        logger.info("SkuServiceImpl.saveGoods,{},{}",goods.getSpu().toString(),goods.getSkuList().toString());
        Spu spu = goods.getSpu();
        spu.setId(idWorker.nextId());
        spuMapper.add(spu);
        Integer category3Id = spu.getCategory3Id();
        Category category = categoryService.findById(category3Id);
        Brand brand = brandService.findById(spu.getBrandId());
        List<Sku> skus = goods.getSkuList();
        for (Sku sku :skus) {
            if(StringUtils.isEmpty(sku.getSpec())){
                sku.setSpec("{}");
            }
            String name = sku.getName();
            Map<String,String> specMap = JSON.parseObject(sku.getSpec(), Map.class);
            for (Map.Entry<String,String> entry:specMap.entrySet()) {
                name += " " + entry.getValue();
            }
            sku.setName(name);
            sku.setId(idWorker.nextId());
            sku.setSpuId(spu.getId());
            Date date = new Date();
            sku.setCreateTime(date);
            sku.setUpdateTime(date);
            //商品分类ID
            sku.setCategoryId(spu.getCategory3Id());
            //分类名字
            sku.setCategoryName(category.getName());
            //品牌名字
            sku.setBrandName(brand.getName());
            skuMapper.add(sku);
        }
    }

    /*
     * @Desc 按照条件分页查询spu
     * @Date 下午9:15 2021/7/24
     * @Author 
     **/
    @Override
    public PageInfo<Spu> findPage(Spu spu, int page, int size) {
        logger.info("SpuServiceImpl.findPage,{},{},{}",spu.toString(),page,size);
        PageHelper.startPage(page,size);
        List<Spu> spus = spuMapper.findList(spu);
        return PageInfo.of(spus);
    }

    /*
     * @Desc 分页查询spu
     * @Date 下午9:13 2021/7/24
     * @Author 
     **/
    @Override
    public PageInfo<Spu> findPage(int page, int size) {
        logger.info("SpuServiceImpl.findPage{},{}",page,size);
        PageHelper.startPage(page,size);
        List<Spu> spus = spuMapper.findAll();
        return PageInfo.of(spus);
    }

    /*
     * @Desc 按照条件查询所以spu
     * @Date 下午9:12 2021/7/24
     * @Author 
     **/
    @Override
    public List<Spu> findList(Spu Spu) {
        logger.info("SpuServiceImpl.findList,{}",Spu.toString());
        return spuMapper.findList(Spu);
    }

    /*
     * @Desc 根据主键删除spu
     * @Date 下午9:12 2021/7/24
     * @Author 
     **/
    @Override
    public void delete(Integer id) {
        logger.info("SpuServiceImpl.delete,{}",id);
        spuMapper.delete(id);
    }

    /*
     * @Desc 更新spu
     * @Date 下午9:12 2021/7/24
     * @Author 
     **/
    @Override
    public void update(Spu spu) {
        logger.info("SpuServiceImpl.update,{}",spu.toString());
        spuMapper.update(spu);
    }

    /*
     * @Desc 添加spu
     * @Date 下午9:11 2021/7/24
     * @Author 
     **/
    @Override
    public void add(Spu spu) {
        logger.info("SpuServiceImpl.add,{}",spu.toString());
        spuMapper.add(spu);
    }

    /*
     * @Desc 根据id查询spu
     * @Date 下午9:11 2021/7/24
     * @Author 
     **/
    @Override
    public Spu findById(Integer id) {
        logger.info("SpuServiceImpl.findById,{}",id);
        return spuMapper.findById(id);
    }

    /*
     * @Desc 查询所以Spu
     * @Date 下午9:11 2021/7/24
     * @Author 
     **/
    @Override
    public List<Spu> findAll() {
        logger.info("SpuServiceImpl.findAll");
        return spuMapper.findAll();
    }
}
