package com.changgou.user.controller;

import com.changgou.user.pojo.TbAddress;
import com.changgou.user.service.TbAddressService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbAddress)表控制层
 *
 * @author makejava
 * @since 2021-12-28 23:43:30
 */
@RestController
@RequestMapping("tbAddress")
public class TbAddressController {
    /**
     * 服务对象
     */
    @Resource
    private TbAddressService tbAddressService;

    /**
     * 分页查询
     *
     * @param tbAddress 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TbAddress>> queryByPage(TbAddress tbAddress, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbAddressService.queryByPage(tbAddress, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TbAddress> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tbAddressService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tbAddress 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TbAddress> add(TbAddress tbAddress) {
        return ResponseEntity.ok(this.tbAddressService.insert(tbAddress));
    }

    /**
     * 编辑数据
     *
     * @param tbAddress 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TbAddress> edit(TbAddress tbAddress) {
        return ResponseEntity.ok(this.tbAddressService.update(tbAddress));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.tbAddressService.deleteById(id));
    }

}

