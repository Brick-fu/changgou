package com.changgou.order.controller;

import com.changgou.order.pojo.Preferential;
import com.changgou.order.service.PreferentialService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Preferential)表控制层
 *
 * @author makejava
 * @since 2022-03-19 14:10:02
 */
@RestController
@RequestMapping("preferential")
public class PreferentialController {
    /**
     * 服务对象
     */
    @Resource
    private PreferentialService preferentialService;

    /**
     * 分页查询
     *
     * @param preferential 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Preferential>> queryByPage(Preferential preferential, PageRequest pageRequest) {
        return ResponseEntity.ok(this.preferentialService.queryByPage(preferential, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Preferential> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.preferentialService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param preferential 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Preferential> add(Preferential preferential) {
        return ResponseEntity.ok(this.preferentialService.insert(preferential));
    }

    /**
     * 编辑数据
     *
     * @param preferential 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Preferential> edit(Preferential preferential) {
        return ResponseEntity.ok(this.preferentialService.update(preferential));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.preferentialService.deleteById(id));
    }

}

