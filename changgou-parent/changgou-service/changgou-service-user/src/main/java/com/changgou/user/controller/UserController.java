package com.changgou.user.controller;

import com.alibaba.fastjson.JSON;
import com.changgou.common.entity.Result;
import com.changgou.common.entity.TokenDecode;
import com.changgou.common.enums.StatusCodeEnum;
import com.changgou.user.pojo.User;
import com.changgou.user.service.UserService;
import com.changgou.common.utils.BCrypt;
import com.changgou.common.utils.JwtUtil;
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
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenDecode tokenDecode;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    /***
     * 增加用户积分
     * @param points:要添加的积分
     */
    @GetMapping(value = "/points/add")
    public Result<Void> addPoints(Integer points){
        //获取用户名
        String username = tokenDecode.getUserName();
        //添加积分
        userService.addUserPoints(username,points);
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(), "添加积分成功！");
    }

    @RequestMapping(value = "/login")
    public Result<String> login(String username, String password, HttpServletResponse response){
        logger.info("TbUserController.login,{},{}",username,password);
        User user = userService.queryById(username);
        if(user != null && BCrypt.checkpw(password, user.getPassword())){
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
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<User>> queryByPage(User user, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userService.queryByPage(user, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public Result<User> queryById(@PathVariable("id") String id) {
        logger.info("TbUserController.queryById,{}",id);
        User user = this.userService.queryById(id);
        if(Objects.isNull(user)){
            return new Result<>(false,StatusCodeEnum.USER_IS_NULL.getCode(), "用户获取失败！",null);
        }
        return new Result<>(true,StatusCodeEnum.SUCCESS.getCode(), "获取成功！", user);
    }

    /**
     * 新增数据
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<User> add(User user) {
        return ResponseEntity.ok(this.userService.insert(user));
    }

    /**
     * 编辑数据
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<User> edit(User user) {
        return ResponseEntity.ok(this.userService.update(user));
    }

    /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.userService.deleteById(id));
    }

}

