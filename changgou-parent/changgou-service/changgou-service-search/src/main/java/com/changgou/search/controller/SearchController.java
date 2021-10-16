package com.changgou.search.controller;

import com.changgou.entity.Result;
import com.changgou.enums.StatusCodeEnum;
import com.changgou.search.service.SkuEsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    private SkuEsService skuEsService;

    @GetMapping("/import")
    public Result<Void> importSku(){
        skuEsService.importSku();
        return new Result<Void>(true, StatusCodeEnum.SUCCESS.getCode(), "导入成功!");
    }

}
