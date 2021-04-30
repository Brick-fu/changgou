package com.changgou.goods.controller;

import com.changgou.entity.Result;
import com.changgou.enums.StatusCodeEnum;
import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;
    Logger logger = LoggerFactory.getLogger(BrandController.class);

    /**
     * @Description 查询全部品牌信息
     * @Param []
     * @Return com.changgou.entity.Result<com.changgou.goods.pojo.Brand>
     * @Date 下午11:33 2021/4/26
     * @Author brick
     **/
    @GetMapping
    public Result<Brand> findAll(){
        logger.info("BrandController.findAll");
        List<Brand> brandList = brandService.findAll();
        return new Result<Brand>(true, StatusCodeEnum.OK.getCode(),"查询成功",brandList) ;
    }

    /**
     * @Description 根据id查询品牌数据
     * @Param [id]
     * @Return com.changgou.entity.Result
     * @Date 下午9:34 2021/4/27
     * @Author brick
     **/
    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable Integer id){
        logger.info("BrandController.findById,{}",id);
        Brand brand = brandService.findById(id);
        return new Result<Brand>(true,StatusCodeEnum.OK.getCode(), "查询成功",brand);
    }

    /**
     * @Description 新增品牌数据
     * @Param [brand]
     * @Return com.changgou.entity.Result<com.changgou.goods.pojo.Brand>
     * @Date 下午9:46 2021/4/27
     * @Author brick
     **/
    @PostMapping
    public Result<Brand> add(@RequestBody Brand brand){
        logger.info("BrandController.add,{}",brand.toString());
        brandService.add(brand);
        return new Result<Brand>(true,StatusCodeEnum.OK.getCode(), "添加成功");
    }

    /**
     * @Description 更新品牌数据
     * @Param [brand, id]
     * @Return com.changgou.entity.Result<com.changgou.goods.pojo.Brand>
     * @Date 下午10:30 2021/4/27
     * @Author brick
     **/
    @PutMapping(value="/{id}")
    public Result<Brand> update(@RequestBody Brand brand,@PathVariable Integer id){
        logger.info("BrandController.update,{},{}",brand.toString(),id);
        brand.setId(id);
        brandService.update(brand);
        return new Result<Brand>(true,StatusCodeEnum.OK.getCode(), "修改成功");
    }

    /**
     * @Description 删除品牌数据
     * @Param [id]
     * @Return com.changgou.entity.Result<com.changgou.goods.pojo.Brand>
     * @Date 下午10:31 2021/4/27
     * @Author bricks
     **/
    @DeleteMapping(value = "/{id}" )
    public Result<Brand> delete(@PathVariable Integer id){
        logger.info("BrandController.delete,{}",id);
        brandService.delete(id);
        return new Result<Brand>(true,StatusCodeEnum.OK.getCode(),"删除成功");
    }

    /**
     * @Description 多条件查询品牌数据
     * @Param [searchMap]
     * @Return com.changgou.entity.Result<com.changgou.goods.pojo.Brand>
     * @Date 下午10:38 2021/4/27
     * @Author brick
     **/
    @PostMapping(value = "/search" )
    public Result<Brand> findList(@RequestBody Brand brand){
        logger.info("BrandController.findList,{}",brand.toString());
        List<Brand> list = brandService.findList(brand);
        return new Result<>(true,StatusCodeEnum.OK.getCode(),"查询成功",list);
    }

    /**
     * @Description 分页查询品牌数据
     * @Param [page, size]
     * @Return com.changgou.entity.Result<com.github.pagehelper.PageInfo<com.changgou.goods.pojo.Brand>>
     * @Date 下午11:23 2021/4/29
     * @Author brick
     **/
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo<Brand>> findPage(@PathVariable Integer page, @PathVariable Integer size){
        PageInfo<Brand> pageList = brandService.findPage(null,page, size);
        return new Result<>(true,StatusCodeEnum.OK.getCode(), "查询成功",pageList);
    }

    /**
     * @Description 分页搜索品牌数据
     * @Param [searchMap, page, size]
     * @Return com.changgou.entity.Result<com.github.pagehelper.PageInfo<com.changgou.goods.pojo.Brand>>
     * @Date 下午11:26 2021/4/29
     * @Author brick
     **/
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo<Brand>> findPage(@RequestBody Brand brand,
                                            @PathVariable Integer page, @PathVariable Integer size){
        PageInfo<Brand> pageList = brandService.findPage(brand, page, size);
        return new Result<>(true,StatusCodeEnum.OK.getCode(), "查询成功",pageList);
    }
}
