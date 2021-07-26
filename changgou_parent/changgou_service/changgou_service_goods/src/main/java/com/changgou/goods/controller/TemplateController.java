package com.changgou.goods.controller;

import com.changgou.entity.Result;
import com.changgou.enums.StatusCodeEnum;
import com.changgou.goods.pojo.Template;
import com.changgou.goods.service.TemplateService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/template")
@CrossOrigin
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    /***
     * Template分页条件搜索实现
     * @param template
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo<Template>> findPage(@RequestBody(required = false) Template template, @PathVariable int page, @PathVariable  int size){
        //执行搜索
        PageInfo<Template> pageInfo = templateService.findPage(template, page, size);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(), "查询成功",pageInfo);
    }


    /***
     * Template分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo<Template>> findPage(@PathVariable  int page, @PathVariable  int size){
        //分页查询
        PageInfo<Template> pageInfo = templateService.findPage(page, size);
        return new Result<>(true, StatusCodeEnum.SUCCESS.getCode(),"查询成功",pageInfo);
    }


    /***
     * 多条件搜索品牌数据
     * @param template
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Template>> findList(@RequestBody(required = false)  Template template){
        List<Template> list = templateService.findList(template);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"查询成功",list);
    }


    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result<Void> delete(@PathVariable Integer id){
        templateService.delete(id);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"删除成功");
    }

    /***
     * 修改Template数据
     * @param template
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result<Void> update(@RequestBody  Template template,@PathVariable Integer id){
        //设置主键值
        template.setId(id);
        //修改数据
        templateService.update(template);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"修改成功");
    }


    /***
     * 新增Template数据
     * @param template
     * @return
     */
    @PostMapping
    public Result<Void> add(@RequestBody   Template template){
        templateService.add(template);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"添加成功");
    }


    /***
     * 根据ID查询Template数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Template> findById(@PathVariable Integer id){
        //根据ID查询
        Template template = templateService.findById(id);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"查询成功",template);
    }


    /***
     * 查询Template全部数据
     * @return
     */
    @GetMapping
    public Result<List<Template>> findAll(){
        List<Template> list = templateService.findAll();
        return new Result<>(true, StatusCodeEnum.SUCCESS.getCode(),"查询成功",list) ;
    }
    
}
