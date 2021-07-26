package com.changgou.goods.controller;

import com.changgou.entity.Result;
import com.changgou.enums.StatusCodeEnum;
import com.changgou.goods.pojo.Sku;
import com.changgou.goods.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sku")
@CrossOrigin
public class SkuController {

    @Autowired
    private SkuService skuService;


    /***
     * 修改sku数据
     * @param sku
     * @return
     */
    @PutMapping(value="/update")
    public Result<Void> update(@RequestBody Sku sku){
        //修改数据
        skuService.update(sku);
        return new Result<>(true, StatusCodeEnum.SUCCESS.getCode(),"修改成功");
    }
}
