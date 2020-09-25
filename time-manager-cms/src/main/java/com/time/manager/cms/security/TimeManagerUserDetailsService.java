package com.time.manager.cms.security;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.time.manage.common.core.exception.BizException;
import com.time.manager.cms.entity.UserInfo;
import com.time.manager.cms.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author wlj
 **/
@Component
@RequiredArgsConstructor
public class TimeManagerUserDetailsService implements UserDetailsService {
    private final UserInfoService userInfoService;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo one = userInfoService.getOne(Wrappers.<UserInfo>query().lambda().eq(UserInfo::getUserName, s));
        if (ObjectUtil.isNull(one)) {
            throw new BizException("用户名有误！");
        }
        return new TimeManagerUserDetails()
                .setPassword(new BCryptPasswordEncoder().encode(one.getUserPassword()))
                .setUserId(one.getUserId())
                .setUsername(one.getUserName())
                .setNickName(one.getUserNickname());
    }


}
