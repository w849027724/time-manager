package com.time.manager.cms.security;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author wlj
 **/
public interface SecurityConstants {

    String header = "Authorization";
    String KEY_TOKEN = "auth:user:";
    String TOKEN_USER = "auth:token:user:";


    /**
     * 默认不拦截路径列表
     */
    List<String> IGNORE_URLS = Lists.newArrayList("/v2/api-docs", "/actuator/**", "/v2/**", "/app/login");

}
