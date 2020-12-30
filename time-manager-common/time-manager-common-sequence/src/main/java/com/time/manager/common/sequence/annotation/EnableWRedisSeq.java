package com.time.manager.common.sequence.annotation;

import com.time.manager.common.sequence.config.RedisSequenceConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({RedisSequenceConfig.class})
public @interface EnableWRedisSeq {
}
