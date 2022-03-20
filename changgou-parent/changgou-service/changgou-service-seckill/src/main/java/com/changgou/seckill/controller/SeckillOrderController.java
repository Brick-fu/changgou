package com.changgou.seckill.controller;

import com.changgou.common.entity.Result;
import com.changgou.common.entity.TokenDecode;
import com.changgou.common.enums.StatusCodeEnum;
import com.changgou.seckill.pojo.SeckillOrder;
import com.changgou.seckill.pojo.SeckillStatus;
import com.changgou.seckill.service.SeckillOrderService;
import com.changgou.seckill.service.impl.SeckillGoodsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SeckillOrder)表控制层
 *
 * @author makejava
 * @since 2022-03-19 12:02:48
 */
@RestController
@RequestMapping("seckill/order")
public class SeckillOrderController {

    @Resource
    private SeckillOrderService seckillOrderService;

    @Autowired
    private TokenDecode tokenDecode;

    private final Logger logger = LoggerFactory.getLogger(SeckillGoodsServiceImpl.class);

    /****
     * 查询抢购
     * @return
     */
    @RequestMapping(value = "/query")
    public Result<SeckillStatus> queryStatus(){
        logger.info("SeckillOrderController.queryStatus");
        //获取用户名
        String username = tokenDecode.getUserName();

        //根据用户名查询用户抢购状态
        SeckillStatus seckillStatus = seckillOrderService.queryStatus(username);

        if(seckillStatus!=null){
            return new Result<>(true,String.valueOf(seckillStatus.getStatus()),"抢购状态",seckillStatus);
        }
        //NOTFOUNDERROR =20006,没有对应的抢购数据
        return new Result<>(false,StatusCodeEnum.NOT_FOUND_DATA.getCode(),"没有抢购信息");
    }

    /****
     * URL:/seckill/order/add
     * 添加订单
     * 调用Service增加订单
     * 匿名访问：anonymousUser
     * @param time
     * @param id
     */
    @RequestMapping(value = "/add")
    public Result<Void> add(String time, Long id){
        logger.info("SeckillOrderController.add,{},{}",time,id);
        try {
            //用户登录名
            String username = tokenDecode.getUserName();
            //调用Service增加订单
            Boolean bo = seckillOrderService.add(id, time, username);
            if(bo){
                //抢单成功
                return new Result<>(true, StatusCodeEnum.SUCCESS.getCode(), "抢单成功！");
            }
        } catch (Exception e) {
            logger.error("抢单失败！",e);
        }
        return new Result<>(true,StatusCodeEnum.ERROR.getCode(),"服务器繁忙，请稍后再试");
    }

    /**
     * 分页查询
     *
     * @param seckillOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<SeckillOrder>> queryByPage(SeckillOrder seckillOrder, PageRequest pageRequest) {
        return ResponseEntity.ok(this.seckillOrderService.queryByPage(seckillOrder, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SeckillOrder> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.seckillOrderService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param seckillOrder 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SeckillOrder> add(SeckillOrder seckillOrder) {
        return ResponseEntity.ok(this.seckillOrderService.insert(seckillOrder));
    }

    /**
     * 编辑数据
     *
     * @param seckillOrder 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SeckillOrder> edit(SeckillOrder seckillOrder) {
        return ResponseEntity.ok(this.seckillOrderService.update(seckillOrder));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.seckillOrderService.deleteById(id));
    }

}

