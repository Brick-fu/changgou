package com.changgou.order.controller;

import com.changgou.order.pojo.OrderConfig;
import com.changgou.order.service.OrderConfigService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (OrderConfig)表控制层
 *
 * @author makejava
 * @since 2022-03-19 14:09:55
 */
@RestController
@RequestMapping("orderConfig")
public class OrderConfigController {
    /**
     * 服务对象
     */
    @Resource
    private OrderConfigService orderConfigService;

    /**
     * 分页查询
     *
     * @param orderConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<OrderConfig>> queryByPage(OrderConfig orderConfig, PageRequest pageRequest) {
        return ResponseEntity.ok(this.orderConfigService.queryByPage(orderConfig, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<OrderConfig> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.orderConfigService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param orderConfig 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<OrderConfig> add(OrderConfig orderConfig) {
        return ResponseEntity.ok(this.orderConfigService.insert(orderConfig));
    }

    /**
     * 编辑数据
     *
     * @param orderConfig 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<OrderConfig> edit(OrderConfig orderConfig) {
        return ResponseEntity.ok(this.orderConfigService.update(orderConfig));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.orderConfigService.deleteById(id));
    }

}

