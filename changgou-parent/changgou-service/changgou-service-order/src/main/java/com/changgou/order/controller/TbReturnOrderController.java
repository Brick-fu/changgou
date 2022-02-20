package com.changgou.order.controller;

import com.changgou.order.pojo.TbReturnOrder;
import com.changgou.order.service.TbReturnOrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbReturnOrder)表控制层
 entity*
 * @author makejava
 * @since 2022-02-14 23:09:13
 */
@RestController
@RequestMapping("returnOrder")
public class TbReturnOrderController {
    /**
     * 服务对象
     */
    @Resource
    private TbReturnOrderService tbReturnOrderService;

    /**
     * 分页查询
     *
     * @param tbReturnOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TbReturnOrder>> queryByPage(TbReturnOrder tbReturnOrder, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbReturnOrderService.queryByPage(tbReturnOrder, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TbReturnOrder> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.tbReturnOrderService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tbReturnOrder 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TbReturnOrder> add(TbReturnOrder tbReturnOrder) {
        return ResponseEntity.ok(this.tbReturnOrderService.insert(tbReturnOrder));
    }

    /**
     * 编辑数据
     *
     * @param tbReturnOrder 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TbReturnOrder> edit(TbReturnOrder tbReturnOrder) {
        return ResponseEntity.ok(this.tbReturnOrderService.update(tbReturnOrder));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.tbReturnOrderService.deleteById(id));
    }

}

