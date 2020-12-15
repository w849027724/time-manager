package com.time.manager.auth.service;

import com.time.manager.cms.api.dto.UserInfoDTO;
import com.time.manager.cms.api.feign.UserFeignClient;
import com.time.manager.security.dto.TimeManagerUserDetails;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author wlj
 **/
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    private final UserFeignClient userFeignClient;

    @Override
    public TimeManagerUserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfoDTO data = userFeignClient.findByName(s).getData();
        if (ObjectUtils.isNotEmpty(data)) {
            TimeManagerUserDetails user = new TimeManagerUserDetails(
                    data.getUserName(),
                    data.getUserPassword(),
                    AuthorityUtils.commaSeparatedStringToAuthorityList("client"));
            user.setNickName(data.getUserNickname());
            user.setUserAvatar(data.getUserAvatar());
            user.setUserId(data.getUserId());
            return user;
        }
        throw  new UsernameNotFoundException("not find");
    }
}
