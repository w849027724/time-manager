package com.time.manager.security.component;


import cn.hutool.core.util.ReUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.google.common.collect.Lists;
import com.time.manager.security.annotation.Ignore;
import com.time.manager.security.common.SecurityConstant;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * 资源服务器对外直接暴露URL
 *
 * @author wulijun
 * @date 2019/11/19 18:44
 */
@Slf4j
@Configuration
@ConfigurationProperties(prefix = "security.oauth2.client")
public class AuthPermitUrlConfig implements InitializingBean {

    private static final Pattern PATTERN = Pattern.compile("\\{(.*?)\\}");
    @Autowired
    private WebApplicationContext applicationContext;

    @Getter
    @Setter
    private List<String> ignoreUrls = Lists.newArrayList();

    @Override
    public void afterPropertiesSet() {
        ignoreUrls.addAll(SecurityConstant.IGNORE_URLS);
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();

        map.keySet().forEach(info -> {
            HandlerMethod handlerMethod = map.get(info);

            // 获取方法上边的注解 存在就添加路径
            Ignore method = AnnotationUtils.findAnnotation(handlerMethod.getMethod(), Ignore.class);
            Optional.ofNullable(method).ifPresent(inner -> info.getPatternsCondition().getPatterns()
                    .forEach(url -> ignoreUrls.add(ReUtil.replaceAll(url, PATTERN, StringPool.ASTERISK))));
        });

    }

}
