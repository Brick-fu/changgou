package com.changgou.user.controller;

import com.changgou.user.entity.TbCities;
import com.changgou.user.service.TbCitiesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 行政区域地州市信息表(TbCities)表控制层
 *
 * @author makejava
 * @since 2021-12-28 23:44:05
 */
@RestController
@RequestMapping("tbCities")
public class TbCitiesController {
    /**
     * 服务对象
     */
    @Resource
    private TbCitiesService tbCitiesService;

    /**
     * 分页查询
     *
     * @param tbCities 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TbCities>> queryByPage(TbCities tbCities, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbCitiesService.queryByPage(tbCities, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TbCities> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.tbCitiesService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tbCities 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TbCities> add(TbCities tbCities) {
        return ResponseEntity.ok(this.tbCitiesService.insert(tbCities));
    }

    /**
     * 编辑数据
     *
     * @param tbCities 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TbCities> edit(TbCities tbCities) {
        return ResponseEntity.ok(this.tbCitiesService.update(tbCities));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.tbCitiesService.deleteById(id));
    }

}

