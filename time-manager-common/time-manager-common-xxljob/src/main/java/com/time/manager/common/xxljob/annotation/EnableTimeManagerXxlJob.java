package com.time.manager.common.xxljob.annotation;


import com.time.manager.common.xxljob.config.XxlJobConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author wlj
 */
@Documented
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({XxlJobConfig.class})
public @interface EnableTimeManagerXxlJob {
}
