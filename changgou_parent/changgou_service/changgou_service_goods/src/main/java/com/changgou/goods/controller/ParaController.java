package com.changgou.goods.controller;

import com.changgou.entity.Result;
import com.changgou.enums.StatusCodeEnum;
import com.changgou.goods.pojo.Para;
import com.changgou.goods.service.ParaService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/para")
@CrossOrigin
public class ParaController {

    private final Logger logger = LoggerFactory.getLogger(ParaController.class);

    @Autowired
    private ParaService paraService;

    /***
     * Para分页条件搜索实现
     * @param para
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo<Para>> findPage(@RequestBody(required = false) Para para, @PathVariable int page, @PathVariable  int size){
        //执行搜索
        PageInfo<Para> pageInfo = paraService.findPage(para, page, size);
        return new Result<>(true, StatusCodeEnum.SUCCESS.getCode(),"查询成功",pageInfo);
    }

    /***
     * Para分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo<Para>> findPage(@PathVariable  int page, @PathVariable  int size){
        //分页查询
        PageInfo<Para> pageInfo = paraService.findPage(page, size);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param para
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Para>> findList(@RequestBody(required = false)  Para para){
        List<Para> list = paraService.findList(para);
        return new Result<List<Para>>(true,StatusCodeEnum.SUCCESS.getCode(),"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result<Void> delete(@PathVariable Integer id){
        paraService.delete(id);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"删除成功");
    }

    /***
     * 修改Para数据
     * @param para
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result<Void> update(@RequestBody  Para para,@PathVariable Integer id){
        //设置主键值
        para.setId(id);
         //修改数据
        paraService.update(para);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"修改成功");
    }

    /***
     * 新增Para数据
     * @param para
     * @return
     */
    @PostMapping
    public Result<Void> add(@RequestBody   Para para){
        paraService.add(para);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"添加成功");
    }

    /***
     * 根据ID查询Para数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
        public Result<Para> findById(@PathVariable Integer id){
        //根据ID查询
        Para para = paraService.findById(id);
        return new Result<Para>(true,StatusCodeEnum.SUCCESS.getCode(),"查询成功",para);
    }

    /***
     * 查询Para全部数据
     * @return
     */
    @GetMapping
    public Result<List<Para>> findAll(){
        List<Para> list = paraService.findAll();
        return new Result<>(true, StatusCodeEnum.SUCCESS.getCode(),"查询成功",list) ;
    }

    /*
     * @Desc 根据分类id获取参数列表
     * @Date 下午5:55 2021/7/24
     * @Author 
     **/
    @GetMapping(value="/category/{id}")
    public Result<List<Para>> findByCategory(@PathVariable(value="id") Integer categoryId){
        List<Para> paras = paraService.findByCategory(categoryId);
        return new Result<>(true, StatusCodeEnum.SUCCESS.getCode(),"查询成功",paras) ;
    }
}
