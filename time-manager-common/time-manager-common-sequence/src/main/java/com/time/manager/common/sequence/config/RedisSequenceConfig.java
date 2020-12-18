package com.time.manager.common.sequence.config;


import com.time.manager.common.sequence.sequence.RedisSequence;
import com.time.manager.common.sequence.sequence.Sequence;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.support.collections.RedisProperties;


@Configuration
@AllArgsConstructor
@ComponentScan("com.time.manager.common.sequence.*")
@ConditionalOnMissingBean(Sequence.class)
public class RedisSequenceConfig {
    /**
     * redisTemplate
     */
    private final ValueOperations valueOperations;
    /**
     * redisProperties
     */
    private final RedisProperties redisProperties;


    @Bean
    public Sequence redisSequence() {
        return new RedisSequence(valueOperations, redisProperties);
    }

}
