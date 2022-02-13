package com.changgou.gateway.filter;

import com.changgou.gateway.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {

    //令牌头名字
    private static final String AUTHORIZE_TOKEN = "Authorization";

    private final Logger logger= LoggerFactory.getLogger(AuthorizeFilter.class);

    /*
     * @Desc 全局拦截
     * @Date 下午10:18 2022/1/2
     * @Author brick
     **/
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        //获取到请求的url
        String path = request.getURI().getPath();
        logger.info("AuthorizeFilter.filter,path={}",path);
        //判断是否是开放的微服务，一般做权限控制
        if(path.startsWith("/api/oauth/login") || path.startsWith("/api/brand/")){
            Mono<Void> mono = chain.filter(exchange);
            return mono;
        }

        //获取jwt数据
        String token = request.getHeaders().getFirst(AUTHORIZE_TOKEN);

        //从cookie中获取
        HttpCookie cookie = request.getCookies().getFirst(AUTHORIZE_TOKEN);
        if(cookie != null){
            token = cookie.getValue();
        }

        if(StringUtils.isEmpty(token)){
            token = request.getQueryParams().getFirst(AUTHORIZE_TOKEN);
        }

        if(StringUtils.isEmpty(token)){
            logger.error("令牌获取失败！");
            response.setStatusCode(HttpStatus.METHOD_NOT_ALLOWED);
            return response.setComplete();
        }
        logger.info("AuthorizeFilter.filter,token={}",token);
        try {
            Claims claims = JwtUtil.parseJWT(token);
            //保存到请求头中，供其他微服务取
            request.mutate().header(AUTHORIZE_TOKEN,claims.toString());
        } catch (Exception e) {
            logger.error("token解析失败！",e);
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        return chain.filter(exchange);
    }

    /*
     * @Desc 过滤器执行顺序
     * @Date 下午10:19 2022/1/2
     * @Author brick
     **/
    @Override
    public int getOrder() {
        return 0;
    }
}
