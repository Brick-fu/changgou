package com.changgou.goods.controller;

import com.changgou.common.entity.Result;
import com.changgou.common.enums.StatusCodeEnum;
import com.changgou.goods.pojo.Sku;
import com.changgou.goods.service.SkuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sku")
@CrossOrigin
public class SkuController {

    @Autowired
    private SkuService skuService;

    private final Logger logger = LoggerFactory.getLogger(SkuController.class);

    @GetMapping("/decr/count")
    public Result<Void> decrCount(@RequestParam Map<String, Integer> map){
        skuService.decrCount(map);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(), "商品库存递减成功！");
    }

    /***
     * 修改sku数据
     * @param sku
     * @return
     */
    @PutMapping(value="/update")
    public Result<Void> update(@RequestBody Sku sku){
        logger.info("SkuController.update,sku={}",sku);
        //修改数据
        skuService.update(sku);
        return new Result<>(true, StatusCodeEnum.SUCCESS.getCode(),"修改成功");
    }

    /***
     * 根据审核状态查询Sku
     * @param status
     * @return
     */
    @GetMapping("/status/{status}")
    public Result<List<Sku>> findByStatus(@PathVariable String status){
        logger.info("SkuController.findByStatus,status={}",status);
        List<Sku> list = skuService.findByStatus(status);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"查询成功",list);
    }

    /***
     * 根据ID查询SKU信息
     * @param id : sku的ID
     */
    @GetMapping(value = "/{id}")
    public Result<Sku> findById(@PathVariable(value = "id") Long id){
        Sku sku = skuService.findById(id);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"查询成功",sku);
    }
}
