package com.changgou.order.controller;

import com.changgou.common.entity.Result;
import com.changgou.common.entity.TokenDecode;
import com.changgou.common.enums.StatusCodeEnum;
import com.changgou.order.pojo.TbOrder;
import com.changgou.order.service.TbOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbOrder)表控制层
 *
 * @author makejava
 * @since 2022-02-14 23:09:12
 */
@RestController
@RequestMapping("/order")
public class TbOrderController {
    /**
     * 服务对象
     */
    @Resource
    private TbOrderService tbOrderService;

    @Autowired
    private TokenDecode tokenDecode;

    private final Logger logger = LoggerFactory.getLogger(TbOrderController.class);


    /**
     * 分页查询
     *
     * @param tbOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TbOrder>> queryByPage(TbOrder tbOrder, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbOrderService.queryByPage(tbOrder, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TbOrder> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.tbOrderService.queryById(id));
    }

    /**
     * 新增订单
     * @param tbOrder 实体
     * @return 新增结果
     */
    @PostMapping(value = "/add")
    public Result<TbOrder> add(@RequestBody TbOrder tbOrder) {
        logger.info("TbOrderController.add,{}",tbOrder);
        //获取用户名
        String username = tokenDecode.getUserName();
        //设置购买用户
        tbOrder.setUsername(username);
        TbOrder order = tbOrderService.saveOrder(tbOrder);
        return new Result<>(true, StatusCodeEnum.SUCCESS.getCode(), "添加成功",order);
    }

    /**
     * 编辑数据
     *
     * @param tbOrder 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TbOrder> edit(TbOrder tbOrder) {
        return ResponseEntity.ok(this.tbOrderService.update(tbOrder));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.tbOrderService.deleteById(id));
    }

}

