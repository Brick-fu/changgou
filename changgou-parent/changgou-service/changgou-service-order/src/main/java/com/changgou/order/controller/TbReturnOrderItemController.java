package com.changgou.order.controller;

import com.changgou.order.pojo.TbReturnOrderItem;
import com.changgou.order.service.TbReturnOrderItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbReturnOrderItem)表控制层
 *
 * @author makejava
 * @since 2022-02-14 23:09:13
 */
@RestController
@RequestMapping("returnOrderItem")
public class TbReturnOrderItemController {
    /**
     * 服务对象
     */
    @Resource
    private TbReturnOrderItemService tbReturnOrderItemService;

    /**
     * 分页查询
     *
     * @param tbReturnOrderItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TbReturnOrderItem>> queryByPage(TbReturnOrderItem tbReturnOrderItem, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbReturnOrderItemService.queryByPage(tbReturnOrderItem, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TbReturnOrderItem> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.tbReturnOrderItemService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tbReturnOrderItem 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TbReturnOrderItem> add(TbReturnOrderItem tbReturnOrderItem) {
        return ResponseEntity.ok(this.tbReturnOrderItemService.insert(tbReturnOrderItem));
    }

    /**
     * 编辑数据
     *
     * @param tbReturnOrderItem 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TbReturnOrderItem> edit(TbReturnOrderItem tbReturnOrderItem) {
        return ResponseEntity.ok(this.tbReturnOrderItemService.update(tbReturnOrderItem));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.tbReturnOrderItemService.deleteById(id));
    }

}

