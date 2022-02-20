package com.changgou.user.feign;

import com.changgou.entity.Result;
import com.changgou.user.pojo.TbUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "changgou-user")
@RequestMapping(value = "/user")
public interface UserFeign {


    /***
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<TbUser> queryById(@PathVariable(value = "id") String id);
}