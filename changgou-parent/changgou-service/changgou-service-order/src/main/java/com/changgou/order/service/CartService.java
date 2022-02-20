package com.changgou.order.service;

import com.changgou.order.pojo.TbOrderItem;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CartService {

    /***
     * 查询用户的购物车数据
     * @param username
     * @return
     */
    List<TbOrderItem> list(String username);

    /***
     * 添加购物车
     * @param num:购买商品数量
     * @param id：购买ID
     * @param username：购买用户
     * @return
     */
    void add(Integer num, Long id, String username);
}
