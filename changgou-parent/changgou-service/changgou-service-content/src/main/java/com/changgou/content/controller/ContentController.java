package com.changgou.content.controller;

import com.changgou.content.pojo.TbContent;
import com.changgou.content.service.TbContentService;
import com.changgou.common.entity.Result;
import com.changgou.common.enums.StatusCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContentController {

    @Autowired
    private TbContentService contentService;

    /***
     * 根据categoryId查询广告集合
     */
    @GetMapping(value = "/list/category/{id}")
    public Result<List<TbContent>> findByCategory(@PathVariable(name = "id") Long id){
        //根据分类ID查询广告集合
        List<TbContent> contents = contentService.findByCategory(id);
        return new Result<List<TbContent>>(true, StatusCodeEnum.SUCCESS.getCode(),"查询成功！",contents);
    }
}
