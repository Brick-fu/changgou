package com.changgou.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.changgou.entity.Result;
import com.changgou.enums.GoodsEnum;
import com.changgou.goods.feign.SkuFeign;
import com.changgou.goods.pojo.Sku;
import com.changgou.search.dao.SkuEsDao;
import com.changgou.search.pojo.SkuInfo;
import com.changgou.search.service.SkuEsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SkuEsServiceImpl implements SkuEsService {

    @Autowired
    private SkuEsDao skuEsDao;
    @Autowired
    private SkuFeign skuFeign;

    private final Logger logger = LoggerFactory.getLogger(SkuEsServiceImpl.class);


    /*
     * @Desc 导入数据到es
     * @Date 下午8:47 2021/10/13
     * @Author
     **/
    @Override
    public void importSku() {
        Result<List<Sku>> skuResult = skuFeign.findByStatus(GoodsEnum.GOODS_STATE_NORMAL.getCode());
        List<Sku> skus = skuResult.getData();
        logger.info("SkuEsServiceImpl.importSku,size:{}",skus.size());
        List<SkuInfo> skuInfos = JSON.parseArray(JSON.toJSONString(skus), SkuInfo.class);
        for (SkuInfo skuInfo:skuInfos) {
            Map<String,Object> map = JSON.parseObject(skuInfo.getSpec());
            skuInfo.setSpecMap(map);
        }
        skuEsDao.saveAll(skuInfos);
    }
}
