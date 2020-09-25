package com.time.manager.cms.security;


import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.time.manage.common.core.enums.ErrorCodeEnum;
import com.time.manage.common.core.utils.R;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 自定义认证成功处理器
 *
 * @author wlj
 **/
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private final String KEY_TOKEN = "auth:user:";
    private final String TOKEN_USER = "auth:token:user:";

    @Resource
    private RedissonClient redissonClient;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        TimeManagerUserDetails accountDetails = (TimeManagerUserDetails) authentication.getPrincipal();
        accountDetails.setPassword(null);
        accountDetails.setToken(setUserToken(accountDetails));
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");
        response.setStatus(ErrorCodeEnum.SUCCESS.getCode());
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), R.ok(accountDetails));
    }

    private String setUserToken(TimeManagerUserDetails accountDetails) {
        String content = JSONUtil.toJsonStr(accountDetails);
        String token = SecureUtil.md5(content);
        // token存储
        RBucket<Object> bucket = redissonClient.getBucket(KEY_TOKEN + token);
        bucket.set(content, 7, TimeUnit.DAYS);
        // 用户token 关系
        RBucket<Object> userToken = redissonClient.getBucket(TOKEN_USER + accountDetails.getUserId());
        userToken.set(token, 7, TimeUnit.DAYS);
        return token;
    }
}
