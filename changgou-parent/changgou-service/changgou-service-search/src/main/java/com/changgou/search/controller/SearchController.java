package com.changgou.search.controller;

import com.changgou.common.entity.Result;
import com.changgou.common.enums.StatusCodeEnum;
import com.changgou.search.service.SkuEsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    private SkuEsService skuEsService;

    /*
     * @Desc 导入sku数据
     * @Date 下午6:09 2021/10/31
     * @Author brick
     **/
    @GetMapping("/import")
    public Result<Void> importSku(){
        skuEsService.importSku();
        return new Result<Void>(true, StatusCodeEnum.SUCCESS.getCode(), "导入成功!");
    }

    /*
     * @Desc 商品搜索
     * @Date 下午6:14 2021/10/31
     * @Author brick
     **/
    @GetMapping
    public Result<Map<String,Object>> search(@RequestParam(required = false) Map<String,String> map) throws IOException {
        Map<String, Object> searchResult = skuEsService.search(map);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"查询成功！",searchResult);
    }

}
