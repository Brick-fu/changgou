package com.changgou.order.controller;

import com.changgou.common.entity.Result;
import com.changgou.common.entity.TokenDecode;
import com.changgou.common.enums.StatusCodeEnum;
import com.changgou.order.pojo.Order;
import com.changgou.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbOrder)表控制层
 *
 * @author makejava
 * @since 2022-02-14 23:09:12
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

    @Autowired
    private TokenDecode tokenDecode;

    private final Logger logger = LoggerFactory.getLogger(OrderController.class);


    /**
     * 分页查询
     *
     * @param order 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Order>> queryByPage(Order order, PageRequest pageRequest) {
        return ResponseEntity.ok(this.orderService.queryByPage(order, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result<Order> queryById(@PathVariable("id") String id) {
        Order order = this.orderService.queryById(id);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(), "查询成功！", order);
    }

    /**
     * 新增订单
     * @param tbOrder 实体
     * @return 新增结果
     */
    @PostMapping(value = "/add")
    public Result<Order> add(@RequestBody Order tbOrder) {
        logger.info("TbOrderController.add,{}",tbOrder);
        //获取用户名
        String username = tokenDecode.getUserName();
        //设置购买用户
        tbOrder.setUsername(username);
        Order order = orderService.saveOrder(tbOrder);
        return new Result<>(true, StatusCodeEnum.SUCCESS.getCode(), "添加成功",order);
    }

    /**
     * 编辑数据
     * @param order 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Order> edit(Order order) {
        return ResponseEntity.ok(this.orderService.update(order));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.orderService.deleteById(id));
    }

}

