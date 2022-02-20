package com.changgou.order.controller;

import com.changgou.order.pojo.TbOrderConfig;
import com.changgou.order.service.TbOrderConfigService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbOrderConfig)表控制层
 *
 * @author makejava
 * @since 2022-02-14 23:09:12
 */
@RestController
@RequestMapping("orderConfig")
public class TbOrderConfigController {
    /**
     * 服务对象
     */
    @Resource
    private TbOrderConfigService tbOrderConfigService;

    /**
     * 分页查询
     *
     * @param tbOrderConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TbOrderConfig>> queryByPage(TbOrderConfig tbOrderConfig, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbOrderConfigService.queryByPage(tbOrderConfig, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TbOrderConfig> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tbOrderConfigService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tbOrderConfig 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TbOrderConfig> add(TbOrderConfig tbOrderConfig) {
        return ResponseEntity.ok(this.tbOrderConfigService.insert(tbOrderConfig));
    }

    /**
     * 编辑数据
     *
     * @param tbOrderConfig 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TbOrderConfig> edit(TbOrderConfig tbOrderConfig) {
        return ResponseEntity.ok(this.tbOrderConfigService.update(tbOrderConfig));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.tbOrderConfigService.deleteById(id));
    }

}

