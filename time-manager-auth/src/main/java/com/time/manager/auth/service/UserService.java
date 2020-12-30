package com.time.manager.auth.service;

import com.time.manager.cms.api.dto.UserInfoDTO;
import com.time.manager.cms.api.feign.UserFeignClient;
import com.time.manager.security.dto.TimeManagerUserDetails;
import com.time.manager.system.controller.api.dto.SysUserDTO;
import com.time.manager.system.controller.api.feign.SysUserFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wlj
 **/
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserFeignClient userFeignClient;
    private final SysUserFeignClient sysUserFeignClient;
    private final HttpServletRequest request;

    @Override
    public TimeManagerUserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        String scope = request.getParameter("scope");

        switch (scope) {
            case "admin":
                SysUserDTO sysUserDTO = sysUserFeignClient.findByName(s).getData();
                TimeManagerUserDetails admin = new TimeManagerUserDetails(
                        sysUserDTO.getSysUserName(),
                        sysUserDTO.getSysUserPassword(),
                        AuthorityUtils.commaSeparatedStringToAuthorityList("client"));
                admin.setNickName("");
                admin.setUserAvatar("");
                admin.setUserId(sysUserDTO.getSysUserId());
                return admin;
            case "user":
                UserInfoDTO data = userFeignClient.findByName(s).getData();
                TimeManagerUserDetails user = new TimeManagerUserDetails(
                        data.getUserName(),
                        data.getUserPassword(),
                        AuthorityUtils.commaSeparatedStringToAuthorityList("client"));
                user.setNickName(data.getUserNickname());
                user.setUserAvatar(data.getUserAvatar());
                user.setUserId(data.getUserId());
                return user;
            default:
                throw new UsernameNotFoundException("not find");
        }
    }
}
