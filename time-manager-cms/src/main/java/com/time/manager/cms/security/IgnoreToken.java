package com.time.manager.cms.security;

import java.lang.annotation.*;

/**
 * Ignore注释 适用方法
 * 凡是使用了改注解的接口不校验token
 * 原理：通过InitializingBean方法初始oauth校验路径，进行忽略
 *
 * @author wulijun
 * @date 2019/11/19 18:41
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreToken {
}
