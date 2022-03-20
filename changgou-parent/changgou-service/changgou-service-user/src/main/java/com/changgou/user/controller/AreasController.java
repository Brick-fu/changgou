package com.changgou.user.controller;

import com.changgou.user.pojo.Areas;
import com.changgou.user.service.AreasService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 行政区域县区信息表(Areas)表控制层
 *
 * @author makejava
 * @since 2022-03-19 14:44:39
 */
@RestController
@RequestMapping("areas")
public class AreasController {
    /**
     * 服务对象
     */
    @Resource
    private AreasService areasService;

    /**
     * 分页查询
     *
     * @param areas 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Areas>> queryByPage(Areas areas, PageRequest pageRequest) {
        return ResponseEntity.ok(this.areasService.queryByPage(areas, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Areas> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.areasService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param areas 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Areas> add(Areas areas) {
        return ResponseEntity.ok(this.areasService.insert(areas));
    }

    /**
     * 编辑数据
     *
     * @param areas 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Areas> edit(Areas areas) {
        return ResponseEntity.ok(this.areasService.update(areas));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.areasService.deleteById(id));
    }

}

