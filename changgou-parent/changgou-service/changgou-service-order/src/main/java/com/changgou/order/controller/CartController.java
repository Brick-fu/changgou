package com.changgou.order.controller;

import com.changgou.common.entity.Result;
import com.changgou.common.entity.TokenDecode;
import com.changgou.common.enums.StatusCodeEnum;
import com.changgou.order.pojo.TbOrderItem;
import com.changgou.order.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private TokenDecode tokenDecode;

    /***
     * 加入购物车
     * @param num:购买的数量
     * @param id：购买的商品(SKU)ID
     * @return
     */
    @RequestMapping(value = "/add")
    public Result<Void> add(Integer num, Long id){
        //用户名
        String username = tokenDecode.getUserName();
        Map<String, Object> userInfo = tokenDecode.getUserInfo();
        //将商品加入购物车
        cartService.add(num,id,username);
        return new Result<>(true, StatusCodeEnum.SUCCESS.getCode(), "加入购物车成功！");
    }

    /***
     * 查询用户购物车列表
     * @return
     */
    @GetMapping(value = "/list")
    public Result<List<TbOrderItem>> list(){
        //用户名
        String username = tokenDecode.getUserName();
        List<TbOrderItem> orderItems = cartService.list(username);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(), "购物车列表查询成功！",orderItems);
    }
}
