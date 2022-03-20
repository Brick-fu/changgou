package com.changgou.order.controller;

import com.changgou.order.pojo.OrderLog;
import com.changgou.order.service.OrderLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (OrderLog)表控制层
 *
 * @author makejava
 * @since 2022-03-19 14:09:59
 */
@RestController
@RequestMapping("orderLog")
public class OrderLogController {
    /**
     * 服务对象
     */
    @Resource
    private OrderLogService orderLogService;

    /**
     * 分页查询
     *
     * @param orderLog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<OrderLog>> queryByPage(OrderLog orderLog, PageRequest pageRequest) {
        return ResponseEntity.ok(this.orderLogService.queryByPage(orderLog, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<OrderLog> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.orderLogService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param orderLog 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<OrderLog> add(OrderLog orderLog) {
        return ResponseEntity.ok(this.orderLogService.insert(orderLog));
    }

    /**
     * 编辑数据
     *
     * @param orderLog 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<OrderLog> edit(OrderLog orderLog) {
        return ResponseEntity.ok(this.orderLogService.update(orderLog));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.orderLogService.deleteById(id));
    }

}

