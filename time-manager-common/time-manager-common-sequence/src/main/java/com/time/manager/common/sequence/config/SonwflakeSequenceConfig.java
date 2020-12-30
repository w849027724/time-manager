package com.time.manager.common.sequence.config;

import com.time.manager.common.sequence.properties.SnowflakeProperties;
import com.time.manager.common.sequence.sequence.Sequence;
import com.time.manager.common.sequence.sequence.SnowflakeSequence;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.time.manager.common.sequence.*")
@ConditionalOnMissingBean(Sequence.class)
public class SonwflakeSequenceConfig {

    @Bean
    public Sequence sonwflakeSequence(SnowflakeProperties properties) {
        return new SnowflakeSequence(properties.getWorkerId(), properties.getWorkerId());
    }

}
