package com.changgou.oauth;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class CreateJwtTest {

    @Test
    public void createJwtDemo(){
        String key_location = "brick.jks";
        String key_alias = "brick";
        String key_password = "brickf";
        String key_secret = "brickf";

        //加载证书文件
        ClassPathResource classPathResource = new ClassPathResource(key_location);

        //创建秘钥工厂
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(classPathResource,key_password.toCharArray());

        //获取公钥、私钥对
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(key_alias, key_password.toCharArray());

        //获取私钥
        RSAPrivateKey rsaPrivate = (RSAPrivateKey) keyPair.getPrivate();

        //封装载体
        Map<String,String> map = new HashMap<>();
        map.put("username","brick");
        map.put("age","26");
        map.put("addr","shanghai");

        //生成jwt令牌
        Jwt jwt = JwtHelper.encode(JSON.toJSONString(map), new RsaSigner(rsaPrivate));

        System.out.println(jwt.getEncoded());

    }

    @Test
    public void parseJwtTest(){
        String publicKey = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAh21jvMLQOgKseMZQSAj0YaaFTHsa33pfgZpho010TnX4qEYgK4S1fuMf0j1AfQd1vUFgKSOFwDquTMXSNkGFvhdrrtBsUdofTAHUwggQOg+dfkC1QeX51ADWjehHAWh+B9DENgJHGmm2M0IVq69AM3+ToirhLxgJs46QEmtObdl0krFcpJu90f9oCNn8QEV9yiFaAJeepQHaIVQeG9+oZIjLydyjG/MS4w72vS5D7Kd7g2QdYO6OGwaETnR1Jx4Vi1NkLHEBxaL1h0cIHpCdzcSmG7bYnyOL00wnECK0bYmLWmJd1UqdxV/oKhk7tL/CoPskBVOICramkXKpKO3SqwIDAQAB-----END PUBLIC KEY-----";
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJiaXJ0aGRheSI6bnVsbCwiY3JlYXRlZCI6MTU1ODE5MTk0MzAwMCwic2V4IjoiMSIsImF1dGhvcml0aWVzIjpbImFkbWluIiwib2F1dGgiXSwiY2xpZW50X2lkIjoiYnJpY2siLCJwb2ludHMiOjcwLCJsYXN0TG9naW5UaW1lIjpudWxsLCJ1c2VyTGV2ZWwiOm51bGwsImV4cGVyaWVuY2VWYWx1ZSI6bnVsbCwicGhvbmUiOiIxMzY3MDAwMDAwMDAiLCJzY29wZSI6WyJhcHAiXSwibmFtZSI6ImhlbGxvIiwiaWQiOiJzeml0aGVpbWEiLCJleHAiOjIwNzczMzI3NjIsImVtYWlsIjoic3ppdGhlaW1hQGl0Y2FzdC5jbiIsImp0aSI6IjU5OTIyODJkLWEzODktNDgwNy04YTc0LWE0YmRhYmIzOTc4ZSIsInVzZXJuYW1lIjoic3ppdGhlaW1hIn0.QvpRRVMwlYTTvGgXORfdlcTrfPXepFqUz1DlIsc9KXV2kpwdPHh2SU3diSM4wYxoTAHqAoy8Qqxpjpk67CkeymkZM5a6ZiNcaLQhpLh6jtNX-rhnKlYbzhGQVWAdwlgMUsGF8ByajauZIS8LcfC9Y7UEGwlgTmZeCU4oIQURLfyC-PSBmApLOFrysDbRtjtXUwd-4ta9vfzUw7Sy4v6gDdsMUakgivXx0iwGqFL23XOqFT2-HWqm6gXTHC_iQ4kpGIwdNDOXo23tVVHh7XPy80AY9lh9xJ6eFf7utBvsJ0BrEbiWid2WU3O-w3_MewiiQeszeaYJ7LInJpyHAxev_g";
        Jwt jwt = JwtHelper.decodeAndVerify(token,new RsaVerifier(publicKey));
        // Jwt jwt = JwtHelper.decode(token);
        System.out.println(jwt.getClaims());

        System.out.println(jwt.getEncoded());
    }
   
}
