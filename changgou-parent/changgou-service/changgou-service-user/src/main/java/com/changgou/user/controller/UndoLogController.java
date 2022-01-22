package com.changgou.user.controller;

import com.changgou.user.pojo.UndoLog;
import com.changgou.user.service.UndoLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (UndoLog)表控制层
 *
 * @author makejava
 * @since 2021-12-28 23:44:05
 */
@RestController
@RequestMapping("undoLog")
public class UndoLogController {
    /**
     * 服务对象
     */
    @Resource
    private UndoLogService undoLogService;

    /**
     * 分页查询
     *
     * @param undoLog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<UndoLog>> queryByPage(UndoLog undoLog, PageRequest pageRequest) {
        return ResponseEntity.ok(this.undoLogService.queryByPage(undoLog, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<UndoLog> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.undoLogService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param undoLog 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<UndoLog> add(UndoLog undoLog) {
        return ResponseEntity.ok(this.undoLogService.insert(undoLog));
    }

    /**
     * 编辑数据
     *
     * @param undoLog 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<UndoLog> edit(UndoLog undoLog) {
        return ResponseEntity.ok(this.undoLogService.update(undoLog));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.undoLogService.deleteById(id));
    }

}

