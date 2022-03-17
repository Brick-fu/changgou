package com.changgou.oauth.util;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.bootstrap.encrypt.KeyProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;

@Component
public class AdminToken {

    @Resource
    private KeyProperties keyProp;

    private static KeyProperties keyProperties;

    // 读取yml文件
    // private static String location;
    // private static String alias;
    // private static String password;
    //
    // @Value("${encrypt.key-store.location}")
    // private String key_location;
    // @Value("${encrypt.key-store.alias}")
    // private String key_alias;
    // @Value("${encrypt.key-store.password}")
    // private String key_password;
    //
    @PostConstruct
    public void init(){
        // location = this.key_location;
        // location = location.replace("classpath:/","");
        // alias = this.key_alias;
        // password = this.key_password;
        AdminToken.keyProperties = this.keyProp;
    }





    public static String getAdminToken(){

        //加载证书文件
        // ClassPathResource classPathResource = new ClassPathResource(location);

        //创建秘钥工厂
        // KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(classPathResource,password.toCharArray());
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(keyProperties.getKeyStore().getLocation(),keyProperties.getKeyStore().getPassword().toCharArray());

        //获取公钥、私钥对
        // KeyPair keyPair = keyStoreKeyFactory.getKeyPair(alias, password.toCharArray());
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(keyProperties.getKeyStore().getAlias(), keyProperties.getKeyStore().getPassword().toCharArray());

        //获取私钥
        RSAPrivateKey rsaPrivate = (RSAPrivateKey) keyPair.getPrivate();

        //封装载体
        Map<String,Object> map = new HashMap<>();
        map.put("username","brick");
        map.put("address","shanghai");
        map.put("authorities",new String[]{"admin","oauth"});

        //生成jwt令牌
        Jwt jwt = JwtHelper.encode(JSON.toJSONString(map), new RsaSigner(rsaPrivate));
        return jwt.getEncoded();
    }
}
