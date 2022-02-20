package com.changgou.order.controller;

import com.changgou.order.pojo.TbCategoryReport;
import com.changgou.order.service.TbCategoryReportService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbCategoryReport)表控制层
 *
 * @author makejava
 * @since 2022-02-14 23:09:02
 */
@RestController
@RequestMapping("categoryReport")
public class TbCategoryReportController {
    /**
     * 服务对象
     */
    @Resource
    private TbCategoryReportService tbCategoryReportService;

    /**
     * 分页查询
     *
     * @param tbCategoryReport 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TbCategoryReport>> queryByPage(TbCategoryReport tbCategoryReport, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbCategoryReportService.queryByPage(tbCategoryReport, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TbCategoryReport> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tbCategoryReportService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tbCategoryReport 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TbCategoryReport> add(TbCategoryReport tbCategoryReport) {
        return ResponseEntity.ok(this.tbCategoryReportService.insert(tbCategoryReport));
    }

    /**
     * 编辑数据
     *
     * @param tbCategoryReport 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TbCategoryReport> edit(TbCategoryReport tbCategoryReport) {
        return ResponseEntity.ok(this.tbCategoryReportService.update(tbCategoryReport));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.tbCategoryReportService.deleteById(id));
    }

}

