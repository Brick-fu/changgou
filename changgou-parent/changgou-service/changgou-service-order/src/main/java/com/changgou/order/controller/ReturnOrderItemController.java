package com.changgou.order.controller;

import com.changgou.order.pojo.ReturnOrderItem;
import com.changgou.order.service.ReturnOrderItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ReturnOrderItem)表控制层
 *
 * @author makejava
 * @since 2022-03-19 14:10:06
 */
@RestController
@RequestMapping("returnOrderItem")
public class ReturnOrderItemController {
    /**
     * 服务对象
     */
    @Resource
    private ReturnOrderItemService returnOrderItemService;

    /**
     * 分页查询
     *
     * @param returnOrderItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<ReturnOrderItem>> queryByPage(ReturnOrderItem returnOrderItem, PageRequest pageRequest) {
        return ResponseEntity.ok(this.returnOrderItemService.queryByPage(returnOrderItem, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ReturnOrderItem> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.returnOrderItemService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param returnOrderItem 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ReturnOrderItem> add(ReturnOrderItem returnOrderItem) {
        return ResponseEntity.ok(this.returnOrderItemService.insert(returnOrderItem));
    }

    /**
     * 编辑数据
     *
     * @param returnOrderItem 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ReturnOrderItem> edit(ReturnOrderItem returnOrderItem) {
        return ResponseEntity.ok(this.returnOrderItemService.update(returnOrderItem));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.returnOrderItemService.deleteById(id));
    }

}

