package com.time.manager.security.common;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author wulijun
 * @date 2019/11/20 10:44
 */
public interface SecurityConstant {

    /**
     * {bcrypt} 加密的特征码
     */
    String BCRYPT = "{bcrypt}";

    /**
     * 内部
     */
    String FROM_IN = "in";
    /**
     * 标志
     */
    String FROM = "from";

    /**
     * JWT_key
     */
    String JWT_KEY = "key";

    /**
     * 资源id
     */
    String RESOURCEID = "timeManager";

    /**
     * client
     */
    String CLIENT = "client";
    /**
     * authorities
     */
    String AUTHORITIES = "oauth2";

    /**
     * Secret
     */
    String SECRET = "123456";
    /**
     * scopes
     */
    String[] SCOPES = {"user", "admin"};

    /**
     * authorizedGrantTypes
     */
    String[] AUTHORIZED_GRANT_TYPES = {"client_credentials", "authorization_code", "refresh_token", "password"};

    /**
     * 默认不拦截路径列表
     */
    List<String> IGNORE_URLS = Lists.newArrayList("/v2/api-docs", "/actuator/**", "/v2/**");

}
