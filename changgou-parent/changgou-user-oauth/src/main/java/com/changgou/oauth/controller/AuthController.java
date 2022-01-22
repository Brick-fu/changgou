package com.changgou.oauth.controller;

import com.changgou.entity.Result;
import com.changgou.enums.StatusCodeEnum;
import com.changgou.exception.BizException;
import com.changgou.oauth.service.AuthService;
import com.changgou.oauth.util.AuthToken;
import com.changgou.oauth.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("user")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Value("${auth.clientId}")
    private String clientId;
    @Value("${auth.clientSecret}")
    private String clientSecret;
    @Value("${auth.cookieDomain}")
    private String cookieDomain;
    @Value(("${auth.cookieMaxAge}"))
    private Integer cookieMaxAge;

    @PostMapping("/login")
    public Result<AuthToken> login(String username, String password){
        if(StringUtils.isEmpty(username)){
            return new Result<>(false, StatusCodeEnum.LOGINERROR.getCode(), "登录名称不能为空!");
        }
        if(StringUtils.isEmpty(password)){
            return new Result<>(false, StatusCodeEnum.LOGINERROR.getCode(), "密码不能为空!");
        }
        AuthToken authToken = authService.login(username, password, clientId, clientSecret);
        saveCookie(authToken.getAccessToken());
        return new Result<>(true, StatusCodeEnum.SUCCESS.getCode(), "登录成功!",authToken);
    }

    /***
     * 将令牌存储到cookie
     * @param token
     */
    private void saveCookie(String token){
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        CookieUtil.addCookie(response,cookieDomain,"/","Authorization",token,cookieMaxAge,false);
    }
}
