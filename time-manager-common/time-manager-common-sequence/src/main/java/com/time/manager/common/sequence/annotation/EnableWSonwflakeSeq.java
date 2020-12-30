package com.time.manager.common.sequence.annotation;


import com.time.manager.common.sequence.config.SonwflakeSequenceConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({SonwflakeSequenceConfig.class})
public @interface EnableWSonwflakeSeq {
}
