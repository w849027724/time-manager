package com.time.manager.common.sequence.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "wtoutiao.sequence.redis")
public class RedisProperties {

    /**
     * 前缀防止key重复(默认 wtoutiao:sequence:redis:)
     */
    private String prefixKey;

    /**
     * 区间步长(默认 0)
     */
    private int step;

    /**
     * 区间起始位置(默认 1)
     */
    private long stepStart;

}
