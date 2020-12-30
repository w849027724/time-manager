package com.time.manager.security.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author wlj
 **/
public class TimeManagerUserDetails extends User {

    /**
     * nickName
     */
    @Getter
    @Setter
    private String nickName;
    /**
     * userAvatar
     */
    @Getter
    @Setter
    private String userAvatar;
    /**
     * userId
     */
    @Getter
    @Setter
    private Long userId;

    public TimeManagerUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
