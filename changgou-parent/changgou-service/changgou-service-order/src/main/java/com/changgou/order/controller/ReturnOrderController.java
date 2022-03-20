package com.changgou.order.controller;

import com.changgou.order.pojo.ReturnOrder;
import com.changgou.order.service.ReturnOrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ReturnOrder)表控制层
 *
 * @author makejava
 * @since 2022-03-19 14:10:05
 */
@RestController
@RequestMapping("returnOrder")
public class ReturnOrderController {
    /**
     * 服务对象
     */
    @Resource
    private ReturnOrderService returnOrderService;

    /**
     * 分页查询
     *
     * @param returnOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<ReturnOrder>> queryByPage(ReturnOrder returnOrder, PageRequest pageRequest) {
        return ResponseEntity.ok(this.returnOrderService.queryByPage(returnOrder, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ReturnOrder> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.returnOrderService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param returnOrder 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ReturnOrder> add(ReturnOrder returnOrder) {
        return ResponseEntity.ok(this.returnOrderService.insert(returnOrder));
    }

    /**
     * 编辑数据
     *
     * @param returnOrder 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ReturnOrder> edit(ReturnOrder returnOrder) {
        return ResponseEntity.ok(this.returnOrderService.update(returnOrder));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.returnOrderService.deleteById(id));
    }

}

