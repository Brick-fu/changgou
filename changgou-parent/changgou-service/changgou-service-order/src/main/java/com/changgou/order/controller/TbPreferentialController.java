package com.changgou.order.controller;

import com.changgou.order.pojo.TbPreferential;
import com.changgou.order.service.TbPreferentialService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbPreferential)表控制层
 *
 * @author makejava
 * @since 2022-02-14 23:09:12
 */
@RestController
@RequestMapping("preferential")
public class TbPreferentialController {
    /**
     * 服务对象
     */
    @Resource
    private TbPreferentialService tbPreferentialService;

    /**
     * 分页查询
     *
     * @param tbPreferential 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TbPreferential>> queryByPage(TbPreferential tbPreferential, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbPreferentialService.queryByPage(tbPreferential, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TbPreferential> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tbPreferentialService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tbPreferential 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TbPreferential> add(TbPreferential tbPreferential) {
        return ResponseEntity.ok(this.tbPreferentialService.insert(tbPreferential));
    }

    /**
     * 编辑数据
     *
     * @param tbPreferential 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TbPreferential> edit(TbPreferential tbPreferential) {
        return ResponseEntity.ok(this.tbPreferentialService.update(tbPreferential));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.tbPreferentialService.deleteById(id));
    }

}

