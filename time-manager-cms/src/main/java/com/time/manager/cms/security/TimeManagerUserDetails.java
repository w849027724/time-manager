package com.time.manager.cms.security;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author wlj
 **/
@Setter
@Getter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class TimeManagerUserDetails implements UserDetails, Serializable {

    @NonNull
    private String username;

    private String token;

    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked = true;

    private boolean credentialsNonExpired = true;

    private boolean enabled = true;

    private Long userId;

    private String nickName;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}
