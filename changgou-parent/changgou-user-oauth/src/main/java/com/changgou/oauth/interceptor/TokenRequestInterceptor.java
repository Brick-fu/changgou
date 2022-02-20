package com.changgou.oauth.interceptor;

import com.changgou.oauth.util.AdminToken;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class TokenRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String adminToken = AdminToken.getAdminToken();
        requestTemplate.header("Authorization",String.format("%s %s",OAuth2AccessToken.BEARER_TYPE,adminToken));
        // headers.put("Authorization", Collections.singletonList(String.format("%s %s",OAuth2AccessToken.BEARER_TYPE,"eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhcHAiXSwibmFtZSI6bnVsbCwiaWQiOm51bGwsImV4cCI6MjA3Njc1ODA4MiwiYXV0aG9yaXRpZXMiOlsic2Vja2lsbF9saXN0IiwiZ29vZHNfbGlzdCJdLCJqdGkiOiJjZWQzMGRlMS00NzZkLTQ5MGItOWI2NC0wOTQ3ODdmNmJkNTkiLCJjbGllbnRfaWQiOiJicmljayIsInVzZXJuYW1lIjoiaXRoZWltYSJ9.GZjX_a6dafXVKUkGE_KpOO4JOdIbyMR_ipkeVjvqCNBha09L9QkysfKHxn17cHiBL_UgKkUzGayM-Qm1jRNNEabXW7VGWWSbry4cAXtKQQYptC8Sw4bQ1N8O4Mf1lZuWxY4GhvIhN5r-mlQDcnSrBB7Osq0T9iCrBhSi8QuA-x0xToZx1NfgzFkFQdPgtnl799bTYv947UY1Rw2tsXvmzLAQHI90KPBsGstCStCx9CAY4b0QO7Kin-c_Eioq_U8yuOogVQiw3R2r3ayPiysW15xjFT8gsngdgazop_yjehvnHDaF-SxERc_ISZ6m82ycYtbam-NVTY3siuTkbniEUA")));
        // requestTemplate.headers(headers);
    }
}
