package com.changgou.seckill.controller;

import com.changgou.common.entity.Result;
import com.changgou.common.enums.StatusCodeEnum;
import com.changgou.common.utils.DateUtil;
import com.changgou.seckill.pojo.SeckillGoods;
import com.changgou.seckill.service.SeckillGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (SeckillGoods)表控制层
 *
 * @author makejava
 * @since 2022-03-19 14:00:27
 */
@RestController
@RequestMapping("/seckill/goods")
public class SeckillGoodsController {
    /**
     * 服务对象
     */
    @Resource
    private SeckillGoodsService seckillGoodsService;

    private final Logger logger = LoggerFactory.getLogger(SeckillGoodsController.class);


    /****
     * URL:/seckill/goods/one
     * 根据ID查询商品详情
     * 调用Service查询商品详情
     * @param time
     * @param id
     */
    @RequestMapping(value = "/detail")
    public SeckillGoods detail(String time,Long id){
        logger.info("SeckillGoodsController.detail,{},{}",time,id);
        //调用Service查询商品详情
        return seckillGoodsService.detail(time,id);
    }


    /****
     * URL:/seckill/goods/list
     * 对应时间段秒杀商品集合查询
     * 调用Service查询数据
     * @param time:2019050716
     */
    @RequestMapping(value = "/list")
    public List<SeckillGoods> list(String time){
        logger.info("SeckillGoodsController.dateMenus,{}",time);
        //调用Service查询数据
        return seckillGoodsService.list(time);
    }

    /*****
     * 获取时间菜单
     * URLL:/seckill/goods/menus
     */
    @RequestMapping(value = "/menus")
    public List<Date> dateMenus(){
        logger.info("SeckillGoodsController.dateMenus");
        return DateUtil.getDateMenus();
    }

    /**
     * 分页查询
     *
     * @param seckillGoods 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<SeckillGoods>> queryByPage(SeckillGoods seckillGoods, PageRequest pageRequest) {
        return ResponseEntity.ok(this.seckillGoodsService.queryByPage(seckillGoods, pageRequest));
    }

    @PostMapping("/list/{page}/{size}")
    public Result<Page<SeckillGoods>> findList(@RequestBody SeckillGoods seckillGoods
            ,@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        logger.info("SeckillGoodsController.findList,{},{},{}",seckillGoods,page,size);
        PageRequest pageRequest = PageRequest.of(page,size);
        Page<SeckillGoods> seckillGoodsPage = this.seckillGoodsService.queryByPage(seckillGoods, pageRequest);
        return new Result<>(true, StatusCodeEnum.SUCCESS.getCode(), "查询成功！",seckillGoodsPage);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SeckillGoods> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.seckillGoodsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param seckillGoods 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SeckillGoods> add(SeckillGoods seckillGoods) {
        return ResponseEntity.ok(this.seckillGoodsService.insert(seckillGoods));
    }

    /**
     * 编辑数据
     *
     * @param seckillGoods 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SeckillGoods> edit(SeckillGoods seckillGoods) {
        return ResponseEntity.ok(this.seckillGoodsService.update(seckillGoods));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.seckillGoodsService.deleteById(id));
    }

}

