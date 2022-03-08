package com.changgou.test;

import com.changgou.common.utils.HttpClient;
import com.github.wxpay.sdk.WXPayUtil;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class WeixinPayTest {

    @Test
    public void getGenerate(){
        String s = WXPayUtil.generateNonceStr();
        System.out.println(s);
    }

    @Test
    public void testMapToXml() throws Exception {
        Map<String,String> map = new HashMap<>();
        map.put("source","changgou");
        map.put("operation","pay");
        String xml = WXPayUtil.mapToXml(map);
        // System.out.println(xml);
        String xml1 = WXPayUtil.generateSignedXml(map, "brick");
        System.out.println(xml1);
        Map<String, String> stringStringMap = WXPayUtil.xmlToMap(xml1);
        System.out.println(stringStringMap);
    }

    @Test
    public void testHttpClient() throws IOException {
        String url = "https://www.baidu.com";
        HttpClient httpClient = new HttpClient(url);
        httpClient.setHttps(true);
        httpClient.post();
        String content = httpClient.getContent();
        System.out.println(content);
    }
}
