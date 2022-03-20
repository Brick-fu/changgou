package com.changgou.user.feign;

import com.changgou.common.entity.Result;
import com.changgou.user.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "changgou-user")
@RequestMapping(value = "/user")
public interface UserFeign {


    /***
     * 增加用户积分
     * @param points:要添加的积分
     */
    @GetMapping(value = "/points/add")
    Result<Void> addPoints(Integer points);

    /***
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<User> queryById(@PathVariable(value = "id") String id);
}
