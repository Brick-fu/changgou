package com.changgou.oauth.service.impl;

import com.changgou.common.enums.StatusCodeEnum;
import com.changgou.common.exception.BizException;
import com.changgou.oauth.service.AuthService;
import com.changgou.oauth.util.AuthToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Base64;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {


    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    private final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);


    /*
     * @Desc 用户登录授权获取token
     * @Date 下午9:48 2022/1/13
     * @Author brick
     **/
    @Override
    public AuthToken login(String username, String password, String clientId, String clientSecret) {
        logger.info("AuthServiceImpl.login,{}",username);
        return applyToken(username, password, clientId, clientSecret);
    }

    private AuthToken applyToken(String username, String password, String clientId, String clientSecret){
        logger.info("AuthServiceImpl.applyToken,{}",username);
        //获取用户认证中心url
        ServiceInstance serviceInstance = loadBalancerClient.choose("user-oauth");
        if (serviceInstance == null) {
            logger.error("AuthServiceImpl.applyToken：通过user-auth找不到服务");
            throw new BizException(StatusCodeEnum.SERVICE_LOSS);
        }
        //获取令牌的url
        String path = serviceInstance.getUri().toString() + "/oauth/token";
        logger.info("AuthServiceImpl.applyToken,path:{}",path);
        MultiValueMap<String,String> bodyMap = new LinkedMultiValueMap<>();
        bodyMap.add("grant_type","password");
        bodyMap.add("username",username);
        bodyMap.add("password",password);

        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization",getHttpBasic(clientId,clientSecret));
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler(){
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                int rawStatusCode = response.getRawStatusCode();
                //当响应的值为400或401时候也要正常响应，不要抛出异常
                if(rawStatusCode != 400 && rawStatusCode != 401){
                    super.handleError(response);
                }
            }
        });
        Map body = null;

        try {
            //http请求spring security的申请令牌接口
            ResponseEntity<Map> exchange = restTemplate.exchange(path, HttpMethod.POST, new HttpEntity<>(bodyMap, headers), Map.class);
            body = exchange.getBody();
        }catch (RestClientException e){
            logger.error("申请令牌失败",e);
            throw new BizException(StatusCodeEnum.LOGINERROR);
        }

        if(body == null || body.get("access_token") == null || body.get("refresh_token") == null || body.get("jti") == null) {
            //jti是jwt令牌的唯一标识作为用户身份令牌
            throw new BizException(StatusCodeEnum.APPLY_TOKEN_FAIL);
        }

        AuthToken authToken = new AuthToken();
        authToken.setAccessToken((String)body.get("access_token"));
        authToken.setRefreshToken((String)body.get("refresh_token"));
        authToken.setJti((String)body.get("jti"));
        return authToken;
    }

    private String getHttpBasic(String clientId, String clientSecret){
        String auth = clientId + ":" + clientSecret;
        return "Basic " + new String(Base64.getEncoder().encode(auth.getBytes()));
    }
}
