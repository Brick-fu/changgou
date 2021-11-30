package com.changgou.goods.controller;

import com.changgou.entity.Result;
import com.changgou.enums.StatusCodeEnum;
import com.changgou.goods.pojo.Sku;
import com.changgou.goods.service.SkuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sku")
@CrossOrigin
public class SkuController {

    @Autowired
    private SkuService skuService;

    private final Logger logger = LoggerFactory.getLogger(SkuController.class);

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
        return new Result<List<Sku>>(true,StatusCodeEnum.SUCCESS.getCode(),"查询成功",list);
    }
}
