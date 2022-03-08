package com.changgou.user.controller;

import com.changgou.common.entity.Result;
import com.changgou.common.entity.TokenDecode;
import com.changgou.common.enums.StatusCodeEnum;
import com.changgou.user.pojo.TbAddress;
import com.changgou.user.service.TbAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbAddress)用户地址
 *
 * @author makejava
 * @since 2021-12-28 23:43:30
 */
@RestController
@RequestMapping("/address")
public class TbAddressController {
    /**
     * 服务对象
     */
    @Resource
    private TbAddressService tbAddressService;

    @Autowired
    private TokenDecode tokenDecode;


    @GetMapping("/list")
    public Result<List<TbAddress>> getUserAddress(){
        String userName = tokenDecode.getUserName();
        List<TbAddress> userAddress = tbAddressService.getUserAddress(userName);
        return new Result<>(true, StatusCodeEnum.SUCCESS.getCode(), "查询成功!",userAddress);
    }

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

