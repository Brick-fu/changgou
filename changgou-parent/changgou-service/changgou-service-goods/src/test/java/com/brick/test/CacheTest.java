package com.brick.test;

import com.changgou.goods.GoodsApplication;
import com.changgou.goods.pojo.Sku;
import com.changgou.goods.service.SkuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest(classes = GoodsApplication.class)
@RunWith(SpringRunner.class)
public class CacheTest {

    @Autowired
    private SkuService skuService;

    @Test
    public void test1(){
        Sku sku = skuService.findById(100000015158L);
        Optional<Sku> optional = Optional.of(sku);
        System.out.println(optional.get());
    }
}
