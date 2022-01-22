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
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhZGRyIjoic2hhbmdoYWkiLCJhZ2UiOiIyNiIsInVzZXJuYW1lIjoiYnJpY2sifQ.RXwt1bgwqZJtsse_VJdAi3KKzfRivr0c7tPZJPDaYx172eT2c3VmQLoLSwgrmF9nC5aLdPfBZV-qYB5Qt5F5d6zau7sIhdzQx4KHNbgfCemMn_gzfl4y4G3eFYhftN6z573YKeR2-WNfquMuZJesUxjElja1fPCpWPvNXWxhNqU7EbyZ2KpzLoaNF0UiccIFK33rzXApmqolpYTt9vFtzQSCQPVMWR2bQQH6kbWOHfVoGfxwGIIWLkJ4stefvQNdOia3OabRlQlcxzvauwosFw1T3q1xHIVhK9EF2b8KC1YGjCG5tVjZKj0t4we3ZlN3Zhnbd457IgkVrYVnPmM2qw";
        Jwt jwt = JwtHelper.decodeAndVerify(token,new RsaVerifier(publicKey));
        // Jwt jwt = JwtHelper.decode(token);
        System.out.println(jwt.getClaims());

        System.out.println(jwt.getEncoded());
    }
   
}
