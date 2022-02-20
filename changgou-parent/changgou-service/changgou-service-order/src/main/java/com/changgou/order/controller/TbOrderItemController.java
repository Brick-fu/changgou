package com.changgou.order.controller;

import com.changgou.order.pojo.TbOrderItem;
import com.changgou.order.service.TbOrderItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbOrderItem)表控制层
 *
 * @author makejava
 * @since 2022-02-14 23:09:12
 */
@RestController
@RequestMapping("orderItem")
public class TbOrderItemController {
    /**
     * 服务对象
     */
    @Resource
    private TbOrderItemService tbOrderItemService;

    /**
     * 分页查询
     *
     * @param tbOrderItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TbOrderItem>> queryByPage(TbOrderItem tbOrderItem, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbOrderItemService.queryByPage(tbOrderItem, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TbOrderItem> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.tbOrderItemService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tbOrderItem 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TbOrderItem> add(TbOrderItem tbOrderItem) {
        return ResponseEntity.ok(this.tbOrderItemService.insert(tbOrderItem));
    }

    /**
     * 编辑数据
     *
     * @param tbOrderItem 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TbOrderItem> edit(TbOrderItem tbOrderItem) {
        return ResponseEntity.ok(this.tbOrderItemService.update(tbOrderItem));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.tbOrderItemService.deleteById(id));
    }

}

