package com.time.manager.common.swagger.annotation;


import com.time.manager.common.swagger.config.SwaggerConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启swagger
 *
 * @author wlj
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({SwaggerConfiguration.class})
public @interface EnableSwagger2 {
}
