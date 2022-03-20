package com.changgou.user.controller;

import com.changgou.user.pojo.Provinces;
import com.changgou.user.service.ProvincesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 省份信息表(Provinces)表控制层
 *
 * @author makejava
 * @since 2022-03-19 14:44:51
 */
@RestController
@RequestMapping("provinces")
public class ProvincesController {
    /**
     * 服务对象
     */
    @Resource
    private ProvincesService provincesService;

    /**
     * 分页查询
     *
     * @param provinces 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Provinces>> queryByPage(Provinces provinces, PageRequest pageRequest) {
        return ResponseEntity.ok(this.provincesService.queryByPage(provinces, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Provinces> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.provincesService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param provinces 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Provinces> add(Provinces provinces) {
        return ResponseEntity.ok(this.provincesService.insert(provinces));
    }

    /**
     * 编辑数据
     *
     * @param provinces 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Provinces> edit(Provinces provinces) {
        return ResponseEntity.ok(this.provincesService.update(provinces));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.provincesService.deleteById(id));
    }

}

