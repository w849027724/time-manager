package com.time.manager.cms.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wlj
 */
@Configuration
@MapperScan("com.time.manager.cms.mapper")
public class MybatisConfig {
}
