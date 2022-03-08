package com.changgou.goods.controller;

import com.changgou.common.entity.Result;
import com.changgou.common.enums.StatusCodeEnum;
import com.changgou.goods.pojo.Spec;
import com.changgou.goods.service.SpecService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spec")
@CrossOrigin
public class SpecController {
    @Autowired
    private SpecService specService;

    /***
     * Spec分页条件搜索实现
     * @param spec
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo<Spec>> findPage(@RequestBody(required = false) Spec spec, @PathVariable int page, @PathVariable  int size){
    //执行搜索
    PageInfo<Spec> pageInfo = specService.findPage(spec, page, size);
        return new Result<>(true, StatusCodeEnum.SUCCESS.getCode(),"查询成功",pageInfo);
    }

    /***
     * Spec分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo<Spec>> findPage(@PathVariable int page, @PathVariable  int size){
    //分页查询
    PageInfo<Spec> pageInfo = specService.findPage(page, size);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param spec
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Spec>> findList(@RequestBody(required = false)  Spec spec){
    List<Spec> list = specService.findList(spec);
        return new Result<List<Spec>>(true,StatusCodeEnum.SUCCESS.getCode(),"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result<Void> delete(@PathVariable Integer id){
        specService.delete(id);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"删除成功");
    }

    /***
     * 修改Spec数据
     * @param spec
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result<Void> update(@RequestBody  Spec spec,@PathVariable Integer id){
        //设置主键值
        spec.setId(id);
        //修改数据
        specService.update(spec);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"修改成功");
    }

    /***
     * 新增Spec数据
     * @param spec
     * @return
     */
    @PostMapping
    public Result<Void> add(@RequestBody  Spec spec){
        specService.add(spec);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"添加成功");
    }

    /***
     * 根据ID查询Spec数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Spec> findById(@PathVariable Integer id){
        //根据ID查询
        Spec spec = specService.findById(id);
        return new Result<Spec>(true,StatusCodeEnum.SUCCESS.getCode(),"查询成功",spec);
    }

    /***
     * 查询Spec全部数据
     * @return
     */
    @GetMapping
    public Result<List<Spec>> findAll(){
        List<Spec> list = specService.findAll();
        return new Result<>(true, StatusCodeEnum.SUCCESS.getCode(),"查询成功",list) ;
    }

    /**
     * @Description 通过分类id获取规格参数
     * @Param [categoryId]
     * @Return com.changgou.common.entity.Result<java.util.List<com.changgou.goods.pojo.Spec>>
     * @Date 下午11:18 2021/7/23
     * @Author brick
     **/
    @GetMapping(value = "/category/{id}")
    public Result<List<Spec>> findByCategory(@PathVariable(value="id") Integer categoryId){
        List<Spec> specs = specService.findByCategory(categoryId);
        return new Result<>(true, StatusCodeEnum.SUCCESS.getCode(),"查询成功",specs) ;
    }
}
