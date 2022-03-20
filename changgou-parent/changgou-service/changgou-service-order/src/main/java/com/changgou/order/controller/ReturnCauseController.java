package com.changgou.order.controller;

import com.changgou.order.pojo.ReturnCause;
import com.changgou.order.service.ReturnCauseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ReturnCause)表控制层
 *
 * @author makejava
 * @since 2022-03-19 14:10:03
 */
@RestController
@RequestMapping("returnCause")
public class ReturnCauseController {
    /**
     * 服务对象
     */
    @Resource
    private ReturnCauseService returnCauseService;

    /**
     * 分页查询
     *
     * @param returnCause 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<ReturnCause>> queryByPage(ReturnCause returnCause, PageRequest pageRequest) {
        return ResponseEntity.ok(this.returnCauseService.queryByPage(returnCause, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ReturnCause> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.returnCauseService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param returnCause 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ReturnCause> add(ReturnCause returnCause) {
        return ResponseEntity.ok(this.returnCauseService.insert(returnCause));
    }

    /**
     * 编辑数据
     *
     * @param returnCause 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ReturnCause> edit(ReturnCause returnCause) {
        return ResponseEntity.ok(this.returnCauseService.update(returnCause));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.returnCauseService.deleteById(id));
    }

}

