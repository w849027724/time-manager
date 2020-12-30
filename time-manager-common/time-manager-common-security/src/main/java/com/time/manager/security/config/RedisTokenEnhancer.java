package com.time.manager.security.config;

import cn.hutool.core.util.ObjectUtil;
import com.time.manager.security.dto.TimeManagerUserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wlj
 **/
public class RedisTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        TimeManagerUserDetails user = (TimeManagerUserDetails) oAuth2Authentication.getUserAuthentication().getPrincipal();
        Map<String, Object> info = new HashMap<>();
        info.put("nickName", ObjectUtil.defaultIfNull(user.getNickName(), ""));
        info.put("userAvatar", ObjectUtil.defaultIfNull(user.getUserAvatar(), ""));
        info.put("userId", ObjectUtil.defaultIfNull(user.getUserId(), 0));
        info.put("userName", ObjectUtil.defaultIfNull(user.getUsername(), ""));
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);
        return oAuth2AccessToken;
    }
}
