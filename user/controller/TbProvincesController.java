package com.changgou.user.controller;

import com.changgou.user.entity.TbProvinces;
import com.changgou.user.service.TbProvincesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 省份信息表(TbProvinces)表控制层
 *
 * @author makejava
 * @since 2021-12-28 23:44:05
 */
@RestController
@RequestMapping("tbProvinces")
public class TbProvincesController {
    /**
     * 服务对象
     */
    @Resource
    private TbProvincesService tbProvincesService;

    /**
     * 分页查询
     *
     * @param tbProvinces 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TbProvinces>> queryByPage(TbProvinces tbProvinces, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbProvincesService.queryByPage(tbProvinces, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TbProvinces> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.tbProvincesService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tbProvinces 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TbProvinces> add(TbProvinces tbProvinces) {
        return ResponseEntity.ok(this.tbProvincesService.insert(tbProvinces));
    }

    /**
     * 编辑数据
     *
     * @param tbProvinces 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TbProvinces> edit(TbProvinces tbProvinces) {
        return ResponseEntity.ok(this.tbProvincesService.update(tbProvinces));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.tbProvincesService.deleteById(id));
    }

}

