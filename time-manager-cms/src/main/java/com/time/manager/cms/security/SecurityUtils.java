package com.time.manager.cms.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author wlj
 **/
@Component
public class SecurityUtils {

    public static TimeManagerUserDetails getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (TimeManagerUserDetails) authentication.getPrincipal();
    }

}
