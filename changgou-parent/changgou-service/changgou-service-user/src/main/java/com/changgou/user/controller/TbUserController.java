package com.changgou.user.controller;

import com.alibaba.fastjson.JSON;
import com.changgou.entity.Result;
import com.changgou.enums.StatusCodeEnum;
import com.changgou.user.pojo.TbUser;
import com.changgou.user.service.TbUserService;
import com.changgou.utils.BCrypt;
import com.changgou.utils.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * 用户表(TbUser)表控制层
 * @author makejava
 * @since 2021-12-28 23:44:05
 */
@RestController
@RequestMapping("/user")
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;

    private final Logger logger = LoggerFactory.getLogger(TbUserController.class);

    @RequestMapping(value = "/login")
    public Result<String> login(String username, String password, HttpServletResponse response){
        logger.info("TbUserController.login,{},{}",username,password);
        TbUser tbUser = tbUserService.queryById(username);
        if(tbUser != null && BCrypt.checkpw(password,tbUser.getPassword())){
            Map<String,Object> map = new HashMap<>();
            map.put("role","USER");
            map.put("username",username);
            map.put("success","SUCCESS");
            String s = JSON.toJSONString(map);
            String jwt = JwtUtil.createJWT(UUID.randomUUID().toString(), s, null);
            //保存到cookie中
            Cookie cookie = new Cookie("Authorization",jwt);
            response.addCookie(cookie);
            return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(),"登录成功!",jwt);
        }
        return new Result<>(false, HttpStatus.UNAUTHORIZED+"","账号或密码错误!");
    }

    /**
     * 分页查询
     * @param tbUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TbUser>> queryByPage(TbUser tbUser, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbUserService.queryByPage(tbUser, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public Result<TbUser> queryById(@PathVariable("id") String id) {
        logger.info("TbUserController.queryById,{}",id);
        TbUser tbUser = this.tbUserService.queryById(id);
        if(Objects.isNull(tbUser)){
            return new Result<>(false,StatusCodeEnum.USER_IS_NULL.getCode(), "用户获取失败！",null);
        }
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(), "获取成功！",tbUser);
    }

    /**
     * 新增数据
     * @param tbUser 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TbUser> add(TbUser tbUser) {
        return ResponseEntity.ok(this.tbUserService.insert(tbUser));
    }

    /**
     * 编辑数据
     * @param tbUser 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TbUser> edit(TbUser tbUser) {
        return ResponseEntity.ok(this.tbUserService.update(tbUser));
    }

    /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.tbUserService.deleteById(id));
    }

}

