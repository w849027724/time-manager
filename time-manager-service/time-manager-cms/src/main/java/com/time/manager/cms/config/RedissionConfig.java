package com.time.manager.cms.config;

import lombok.RequiredArgsConstructor;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wlj
 **/
@Configuration
@ConditionalOnClass(Config.class)
@EnableConfigurationProperties(RedissonProperties.class)
@RequiredArgsConstructor
public class RedissionConfig {
    private final RedissonProperties redissonProperties;

    /**
     * 单机模式自动装配
     *
     * @return
     */
    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress(redissonProperties.getAddress())
                .setPassword(redissonProperties.getPassword())
                .setDatabase(redissonProperties.getDatabase());

        return Redisson.create(config);
    }

}
