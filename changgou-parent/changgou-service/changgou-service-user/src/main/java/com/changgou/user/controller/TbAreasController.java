package com.changgou.user.controller;

import com.changgou.user.pojo.TbAreas;
import com.changgou.user.service.TbAreasService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 行政区域县区信息表(TbAreas)表控制层
 *
 * @author makejava
 * @since 2021-12-28 23:44:05
 */
@RestController
@RequestMapping("tbAreas")
public class TbAreasController {
    /**
     * 服务对象
     */
    @Resource
    private TbAreasService tbAreasService;

    /**
     * 分页查询
     *
     * @param tbAreas 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TbAreas>> queryByPage(TbAreas tbAreas, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbAreasService.queryByPage(tbAreas, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TbAreas> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.tbAreasService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tbAreas 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TbAreas> add(TbAreas tbAreas) {
        return ResponseEntity.ok(this.tbAreasService.insert(tbAreas));
    }

    /**
     * 编辑数据
     *
     * @param tbAreas 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TbAreas> edit(TbAreas tbAreas) {
        return ResponseEntity.ok(this.tbAreasService.update(tbAreas));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.tbAreasService.deleteById(id));
    }

}

