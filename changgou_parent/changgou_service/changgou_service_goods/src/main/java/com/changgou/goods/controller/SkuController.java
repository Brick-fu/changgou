package com.changgou.goods.controller;

import com.changgou.entity.Result;
import com.changgou.enums.StatusCodeEnum;
import com.changgou.goods.pojo.Goods;
import com.changgou.goods.service.SkuService;
import com.changgou.goods.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "spu")
@CrossOrigin
public class SkuController {

    @Autowired
    private SpuService spuService;

    /***
     * 添加Goods
     * @param goods
     * @return
     */
    @PostMapping("/save")
    public Result<Void> save(@RequestBody Goods goods) {
        spuService.saveGoods(goods);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(), "保存成功");
    }
}
