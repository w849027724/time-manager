package com.time.manager.cms.security;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.time.manage.common.core.enums.ErrorCodeEnum;
import com.time.manage.common.core.utils.R;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author wlj
 **/
@Component
@ConditionalOnBean(RedissonClient.class)
public class MyAuthenticationFilter extends OncePerRequestFilter {
    @Resource
    private RedissonClient redissonClient;
    @Resource
    private AuthPermitUrlConfig authPermitUrlConfig;


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        List<String> ignoreUrls = authPermitUrlConfig.getIgnoreUrls();
        if (ignoreUrls != null && ignoreUrls.size() > 0) {
            for (String pattern : ignoreUrls) {
                String uri = request.getRequestURI();
                if (uri.equalsIgnoreCase(pattern)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestHeader = request.getHeader(SecurityConstants.header);
        if (ObjectUtil.isEmpty(requestHeader)) {
            if (this.shouldNotFilter(request)) {
                filterChain.doFilter(request, response);
                return;
            }
            // 权限不足
            this.sendUnToken(response);
        }
        String authToken = requestHeader.trim();
        // token存储
        RBucket<Object> bucket = redissonClient.getBucket(SecurityConstants.KEY_TOKEN + authToken);
        String o = (String) bucket.get();
        if (!bucket.isExists()) {
            // 权限不足
            this.sendUnToken(response);
        }
        this.setSecurityContextHolder(bucket);
        filterChain.doFilter(request, response);
    }

    private void setSecurityContextHolder(RBucket<Object> bucket) {
        String o = (String) bucket.get();
        TimeManagerUserDetails timeManagerUserDetails = JSONUtil.toBean(o, TimeManagerUserDetails.class);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(timeManagerUserDetails, null, timeManagerUserDetails
                .getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    }


    private void sendUnToken(HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        mapper.writeValue(response.getWriter(), R.failed(ErrorCodeEnum.UNAUTHORIZED.getCode(), "权限不足!"));
    }
}
