package com.changgou.user.controller;

import com.changgou.user.pojo.Cities;
import com.changgou.user.service.CitiesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 行政区域地州市信息表(Cities)表控制层
 *
 * @author makejava
 * @since 2022-03-19 14:44:51
 */
@RestController
@RequestMapping("cities")
public class CitiesController {
    /**
     * 服务对象
     */
    @Resource
    private CitiesService citiesService;

    /**
     * 分页查询
     *
     * @param cities 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Cities>> queryByPage(Cities cities, PageRequest pageRequest) {
        return ResponseEntity.ok(this.citiesService.queryByPage(cities, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Cities> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.citiesService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param cities 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Cities> add(Cities cities) {
        return ResponseEntity.ok(this.citiesService.insert(cities));
    }

    /**
     * 编辑数据
     *
     * @param cities 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Cities> edit(Cities cities) {
        return ResponseEntity.ok(this.citiesService.update(cities));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.citiesService.deleteById(id));
    }

}

