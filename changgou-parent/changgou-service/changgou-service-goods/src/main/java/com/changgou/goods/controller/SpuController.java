package com.changgou.goods.controller;

import com.changgou.entity.Result;
import com.changgou.enums.StatusCodeEnum;
import com.changgou.goods.pojo.Goods;
import com.changgou.goods.pojo.Spu;
import com.changgou.goods.service.SpuService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/spu")
@CrossOrigin
@Api(value = "spu类操作")
public class SpuController {

    @Autowired
    private SpuService spuService;

    /***
     * Spu分页条件搜索实现
     * @param spu
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "查询spu",notes = "多条件分页查询数据")
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo<Spu>> findPage(@RequestBody(required = false) Spu spu, @PathVariable  int page, @PathVariable  int size){
        //执行搜索
        PageInfo<Spu> pageInfo = spuService.findPage(spu, page, size);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"查询成功",pageInfo);
    }
    
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

    /***
     * 根据ID查询Goods
     * @param id
     * @return
     */
    @GetMapping("/goods/{id}")
    public Result<Goods> findGoodsById(@PathVariable Long id){
        //根据ID查询Goods(SPU+SKU)信息
        Goods goods = spuService.findGoodsById(id);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"查询成功",goods);
    }

    /**
     * 审核
     * @param id
     * @return
     */
    @PutMapping("/audit/{id}")
    public Result<Void> audit(@PathVariable Long id){
        spuService.audit(id);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(), "审核成功");
    }

    /**
     * 物理删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        spuService.delete(id);
        return new Result<>(true, StatusCodeEnum.SUCCESS.getCode(), "删除成功");
    }

    /**
     * 下架
     * @param id
     * @return
     */
    @PutMapping("/pull/{id}")
    public Result<Void> pull(@PathVariable Long id) {
        spuService.pullOffShelves(id);
        return new Result<>(true, StatusCodeEnum.SUCCESS.getCode(), "下架成功");
    }

    /**
     * 商品上架
     * @param id
     * @return
     */
    @PutMapping("/put/{id}")
    public Result<Void> put(@PathVariable Long id){
        spuService.putOnShelves(id);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"上架成功");
    }

    /**
     *  批量上架
     * @param ids
     * @return
     */
    @PutMapping("/put/many")
    public Result<Void> putMany(@RequestBody Long[] ids){
        int count = spuService.putMany(ids);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"上架"+count+"个商品");
    }

    /**
     *  批量下架
     * @param ids
     * @return
     */
    @PutMapping("/pull/many")
    public Result<Void> pullMany(@RequestBody Long[] ids){
        int count = spuService.pullMany(ids);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"下架"+count+"个商品");
    }

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    @DeleteMapping("/logic/delete/{id}")
    public Result<Void> logicDelete(@PathVariable Long id){
        spuService.logicDelete(id);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"逻辑删除成功！");
    }

    /**StatusCode.OK
     * 恢复数据
     * @param id
     * @return
     */
    @PutMapping("/restore/{id}")
    public Result<Void> restore(@PathVariable Long id){
        spuService.restore(id);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"数据恢复成功！");
    }

    /***
     * 根据SpuID查询Spu信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Spu> findById(@PathVariable(name = "id") Long id){
        Spu spu = spuService.findById(id);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"查询成功",spu);
    }

}
