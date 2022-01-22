package com.brick.test;

import io.jsonwebtoken.*;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class JWTDemo {

    @Test
    public void createJWT(){
        Map<String,Object> map = new HashMap<>();
        map.put("username","brick");
        map.put("age",23);
        map.put("addr","上海浦东新区");
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("88888888")
                .setSubject("创建JWT")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+60000))
                .signWith(SignatureAlgorithm.HS256, "helloworld");
        jwtBuilder.addClaims(map);
        System.out.println(jwtBuilder.compact());
    }

    @Test
    public void parseJWT(){
        String compactJwt = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODg4ODg4OCIsInN1YiI6IuWIm-W7ukpXVCIsImlhdCI6MTY0MTEyNjE3MCwiZXhwIjoxNjQxMTI2MjMwLCJhZGRyIjoi5LiK5rW35rWm5Lic5paw5Yy6IiwiYWdlIjoyMywidXNlcm5hbWUiOiJicmljayJ9.4l8IQam5lCtwzDkmDZQO6VKB_u6H-wUgRQ7-fL4Uv0g";
        Claims result = Jwts.parser()
                .setSigningKey("helloworld")
                .parseClaimsJws(compactJwt).getBody();
        System.out.println(result);
    }
}
