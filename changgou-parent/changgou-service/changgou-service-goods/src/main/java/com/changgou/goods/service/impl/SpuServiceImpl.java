package com.changgou.goods.service.impl;

import com.alibaba.fastjson.JSON;
import com.changgou.enums.GoodsEnum;
import com.changgou.enums.StatusCodeEnum;
import com.changgou.exception.BizException;
import com.changgou.goods.dao.BrandMapper;
import com.changgou.goods.dao.CategoryMapper;
import com.changgou.goods.dao.SkuMapper;
import com.changgou.goods.dao.SpuMapper;
import com.changgou.goods.pojo.*;
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
    private CategoryMapper categoryMapper;
    @Autowired
    private BrandMapper brandMapper;

    private final Logger logger = LoggerFactory.getLogger(SpuServiceImpl.class);

    @Override
    public void putOnShelves(Long spuId) {
        Spu spu = spuMapper.findById(spuId);
        if(GoodsEnum.DELETE_YES.getCode().equals(spu.getIsDelete())){
            throw new BizException(StatusCodeEnum.GOODS_DELETED);
        }
        if(!GoodsEnum.AUDITED.getCode().equals(spu.getStatus())){
            throw new BizException(StatusCodeEnum.AUDITED_NO_PASS_TIP);
        }
        spu.setIsMarketable(GoodsEnum.MARKETABLE_YES.getCode()); //上架
        spuMapper.update(spu);
    }

    @Override
    public void pullOffShelves(Long spuId) {
        Spu spu = spuMapper.findById(spuId);
        if(GoodsEnum.DELETE_YES.getCode().equals(spu.getIsDelete())){
            throw new BizException(StatusCodeEnum.GOODS_DELETED);
        }
        spu.setIsMarketable(GoodsEnum.MARKETABLE_NO.getCode()); //下架
        spuMapper.update(spu);
    }

    @Override
    public void audit(Long spuId) {
        Spu spu = spuMapper.findById(spuId);
        if(GoodsEnum.DELETE_YES.getCode().equals(spu.getIsDelete())){
            throw new BizException(StatusCodeEnum.GOODS_DELETED);
        }
        spu.setStatus(GoodsEnum.AUDITED.getCode()); //审核通过
        spu.setIsMarketable(GoodsEnum.MARKETABLE_YES.getCode()); //上架
        spuMapper.update(spu);
    }

    @Override
    public Goods findGoodsById(Long spuId) {
        Spu spu = spuMapper.findById(spuId);
        Sku sku = new Sku();
        sku.setSpuId(spuId);
        List<Sku> skus = skuMapper.findList(sku);
        Goods goods = new Goods();
        goods.setSpu(spu);
        goods.setSkuList(skus);
        return goods;
    }

    @Override
    public void saveGoods(Goods goods) {
        logger.info("SkuServiceImpl.saveGoods,{},{}",goods.getSpu().toString(),goods.getSkuList().toString());
        Spu spu = goods.getSpu();
        Long spuId = spu.getId();
        if(spuId == null){
            spu.setId(idWorker.nextId());
            spuMapper.add(spu);
        }else{
            spuMapper.update(spu);
            skuMapper.deleteBySpuId(spuId);
        }
        Integer category3Id = spu.getCategory3Id();
        Category category = categoryMapper.findById(category3Id);
        Brand brand = brandMapper.findById(spu.getBrandId());
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
    public void delete(Long id) {
        logger.info("SpuServiceImpl.delete,{}",id);
        Spu spu = spuMapper.findById(id);
        //检查是否被逻辑删除  ,必须先逻辑删除后才能物理删除
        if(!GoodsEnum.DELETE_YES.getCode().equals(spu.getIsDelete())){
            throw new BizException(StatusCodeEnum.GOODS_CANNOT_DELETE);
        }
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
    public Spu findById(Long id) {
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

    @Override
    public int putMany(Long[] ids) {
        return spuMapper.batchLoadingAndUnloading(GoodsEnum.MARKETABLE_YES.getCode(),ids);
    }

    @Override
    public int pullMany(Long[] ids) {
        return spuMapper.batchLoadingAndUnloading(GoodsEnum.MARKETABLE_NO.getCode(),ids);
    }

    @Override
    public void logicDelete(Long spuId) {
        Spu spu = spuMapper.findById(spuId);
        //检查是否下架的商品
        if (!GoodsEnum.MARKETABLE_NO.getCode().equals(spu.getIsMarketable())) {
            throw new BizException(StatusCodeEnum.GOODS_MUST_PUT_ON_SHELVES);
        }
        //删除
        spu.setIsDelete("1");
        //未审核
        spu.setStatus("0");
        spuMapper.update(spu);
    }

    @Override
    public void restore(Long spuId) {
        Spu spu = spuMapper.findById(spuId);
        //检查是否删除的商品
        if (!GoodsEnum.DELETE_YES.getCode().equals(spu.getIsDelete())) {
            throw new BizException(StatusCodeEnum.GOODS_NOT_DELETE);
        }
        //未删除
        spu.setIsDelete("0");
        //未审核
        spu.setStatus("0");
        spuMapper.update(spu);
    }
}
