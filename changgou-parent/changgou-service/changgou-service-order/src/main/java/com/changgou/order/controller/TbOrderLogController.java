package com.changgou.order.controller;

import com.changgou.order.pojo.TbOrderLog;
import com.changgou.order.service.TbOrderLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbOrderLog)表控制层
 *
 * @author makejava
 * @since 2022-02-14 23:09:12
 */
@RestController
@RequestMapping("orderLog")
public class TbOrderLogController {
    /**
     * 服务对象
     */
    @Resource
    private TbOrderLogService tbOrderLogService;

    /**
     * 分页查询
     *
     * @param tbOrderLog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TbOrderLog>> queryByPage(TbOrderLog tbOrderLog, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbOrderLogService.queryByPage(tbOrderLog, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TbOrderLog> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.tbOrderLogService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tbOrderLog 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TbOrderLog> add(TbOrderLog tbOrderLog) {
        return ResponseEntity.ok(this.tbOrderLogService.insert(tbOrderLog));
    }

    /**
     * 编辑数据
     *
     * @param tbOrderLog 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TbOrderLog> edit(TbOrderLog tbOrderLog) {
        return ResponseEntity.ok(this.tbOrderLogService.update(tbOrderLog));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.tbOrderLogService.deleteById(id));
    }

}

