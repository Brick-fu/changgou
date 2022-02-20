package com.changgou.order.controller;

import com.changgou.order.pojo.TbReturnCause;
import com.changgou.order.service.TbReturnCauseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbReturnCause)表控制层
 *
 * @author makejava
 * @since 2022-02-14 23:09:13
 */
@RestController
@RequestMapping("returnCause")
public class TbReturnCauseController {
    /**
     * 服务对象
     */
    @Resource
    private TbReturnCauseService tbReturnCauseService;

    /**
     * 分页查询
     *
     * @param tbReturnCause 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TbReturnCause>> queryByPage(TbReturnCause tbReturnCause, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbReturnCauseService.queryByPage(tbReturnCause, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TbReturnCause> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tbReturnCauseService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tbReturnCause 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TbReturnCause> add(TbReturnCause tbReturnCause) {
        return ResponseEntity.ok(this.tbReturnCauseService.insert(tbReturnCause));
    }

    /**
     * 编辑数据
     *
     * @param tbReturnCause 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TbReturnCause> edit(TbReturnCause tbReturnCause) {
        return ResponseEntity.ok(this.tbReturnCauseService.update(tbReturnCause));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.tbReturnCauseService.deleteById(id));
    }

}

