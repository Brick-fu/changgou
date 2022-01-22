package com.changgou.user.entity;

import java.io.Serializable;

/**
 * (OauthClientDetails)实体类
 *
 * @author makejava
 * @since 2021-12-28 23:41:54
 */
public class OauthClientDetails implements Serializable {
    private static final long serialVersionUID = -13398638357505759L;
    /**
     * 客户端ID，主要用于标识对应的应用
     */
    private String clientId;
    
    private String resourceIds;
    /**
     * 客户端秘钥，BCryptPasswordEncoder加密算法加密
     */
    private String clientSecret;
    /**
     * 对应的范围
     */
    private String scope;
    /**
     * 认证模式
     */
    private String authorizedGrantTypes;
    /**
     * 认证后重定向地址
     */
    private String webServerRedirectUri;
    
    private String authorities;
    /**
     * 令牌有效期
     */
    private Integer accessTokenValidity;
    /**
     * 令牌刷新周期
     */
    private Integer refreshTokenValidity;
    
    private String additionalInformation;
    
    private String autoapprove;


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getAutoapprove() {
        return autoapprove;
    }

    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }

}

