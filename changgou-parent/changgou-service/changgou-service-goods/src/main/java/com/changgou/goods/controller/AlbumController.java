package com.changgou.goods.controller;

import com.changgou.common.entity.Result;
import com.changgou.common.enums.StatusCodeEnum;
import com.changgou.goods.pojo.Album;
import com.changgou.goods.service.AlbumService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
@CrossOrigin
public class AlbumController {

    @Autowired
    private AlbumService albumService;

   /**
    * @Description Album分页条件搜索实现
    * @Param [album, page, size]
    * @Return com.changgou.common.entity.Result<com.github.pagehelper.PageInfo>
    * @Date 下午10:54 2021/6/9
    * @Author brick
    **/
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Album>> findPage(@RequestBody(required = false) Album album, @PathVariable int page, @PathVariable  int size){
        //执行搜索
        PageInfo<Album> pageInfo = albumService.findPage(album, page, size);
        return new Result<>(true, StatusCodeEnum.SUCCESS.getCode(), "查询成功",pageInfo);
    }

    

   /**
    * @Description Album分页搜索实现
    * @Param [page, size]
    * @Return com.changgou.common.entity.Result<com.github.pagehelper.PageInfo<com.changgou.goods.pojo.Album>>
    * @Date 下午11:03 2021/6/9
    * @Author brick
    **/
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo<Album>> findPage(@PathVariable int page, @PathVariable int size){
        //分页查询
        PageInfo<Album> pageInfo = albumService.findPage(page, size);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(), "查询成功",pageInfo);
    }


    /**
     * @Description 多条件搜索品牌数据
     * @Param [album]
     * @Return com.changgou.common.entity.Result<java.util.List<com.changgou.goods.pojo.Album>>
     * @Date 下午10:53 2021/6/9
     * @Author brick
     **/
    @PostMapping(value = "/search" )
    public Result<List<Album>> findList(@RequestBody(required = false)  Album album){
        List<Album> list = albumService.findList(album);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"查询成功",list);
    }


    /**
     * @Description 根据ID删除品牌数据
     * @Param [id]
     * @Return com.changgou.common.entity.Result<java.lang.Void>
     * @Date 下午10:53 2021/6/9
     * @Author brick
     **/
    @DeleteMapping(value = "/{id}" )
    public Result<Void> delete(@PathVariable Long id){
        albumService.delete(id);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"删除成功");
    }


    /**
     * @Description 修改Album数据
     * @Param [album, id]
     * @Return com.changgou.common.entity.Result<java.lang.Void>
     * @Date 下午10:52 2021/6/9
     * @Author brick
     **/
    @PutMapping(value="/{id}")
    public Result<Void> update(@RequestBody  Album album,@PathVariable Long id){
        //设置主键值
        album.setId(id);
        //修改数据
        albumService.update(album);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"修改成功");
    }


   /**
    * @Description 新增Album数据
    * @Param [album]
    * @Return com.changgou.common.entity.Result<java.lang.Void>
    * @Date 下午10:52 2021/6/9
    * @Author brick
    **/
    @PostMapping
    public Result<Void> add(@RequestBody   Album album){
        albumService.add(album);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"添加成功");
    }


    /**
     * @Description 根据ID查询Album数据
     * @Param [id]
     * @Return com.changgou.common.entity.Result<com.changgou.goods.pojo.Album>
     * @Date 下午10:52 2021/6/9
     * @Author brick
     **/
    @GetMapping("/{id}")
    public Result<Album> findById(@PathVariable Long id){
        //根据ID查询
        Album album = albumService.findById(id);
        return new Result<Album>(true,StatusCodeEnum.SUCCESS.getCode(),"查询成功",album);
    }


    /**
     * @Description 查询Album全部数据
     * @Param []
     * @Return com.changgou.common.entity.Result<java.util.List<com.changgou.goods.pojo.Album>>
     * @Date 下午10:52 2021/6/9
     * @Author brick
     **/
    @GetMapping
    public Result<List<Album>> findAll(){
        List<Album> list = albumService.findAll();
        return new Result<>(true, StatusCodeEnum.SUCCESS.getCode(),"查询成功",list) ;
    }
}
