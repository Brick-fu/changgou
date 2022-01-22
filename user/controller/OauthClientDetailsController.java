package com.changgou.user.controller;

import com.changgou.user.entity.OauthClientDetails;
import com.changgou.user.service.OauthClientDetailsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (OauthClientDetails)表控制层
 *
 * @author makejava
 * @since 2021-12-28 23:41:52
 */
@RestController
@RequestMapping("oauthClientDetails")
public class OauthClientDetailsController {
    /**
     * 服务对象
     */
    @Resource
    private OauthClientDetailsService oauthClientDetailsService;

    /**
     * 分页查询
     *
     * @param oauthClientDetails 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<OauthClientDetails>> queryByPage(OauthClientDetails oauthClientDetails, PageRequest pageRequest) {
        return ResponseEntity.ok(this.oauthClientDetailsService.queryByPage(oauthClientDetails, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<OauthClientDetails> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.oauthClientDetailsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param oauthClientDetails 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<OauthClientDetails> add(OauthClientDetails oauthClientDetails) {
        return ResponseEntity.ok(this.oauthClientDetailsService.insert(oauthClientDetails));
    }

    /**
     * 编辑数据
     *
     * @param oauthClientDetails 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<OauthClientDetails> edit(OauthClientDetails oauthClientDetails) {
        return ResponseEntity.ok(this.oauthClientDetailsService.update(oauthClientDetails));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.oauthClientDetailsService.deleteById(id));
    }

}

