package com.time.manager.common.sequence.sequence;

import cn.hutool.core.util.ObjectUtil;
import com.time.manager.common.sequence.exception.SeqException;
import com.time.manager.common.sequence.properties.RedisProperties;
import org.springframework.data.redis.core.ValueOperations;



public class RedisSequence implements Sequence {
    /**
     * 默认key
     */
    private final String DEF_KEY = "wtoutiao:sequence:redis:";
    /**
     * redisTemplate
     */
    private ValueOperations valueOperations;
    /**
     * redisProperties
     */
    private RedisProperties redisProperties;

    public RedisSequence(ValueOperations valueOperations, RedisProperties redisProperties) {
        this.valueOperations = valueOperations;
        this.redisProperties = redisProperties;
    }

    @Override
    public synchronized long nextSequence() throws SeqException {
        String key = ObjectUtil.defaultIfNull(redisProperties.getPrefixKey(), DEF_KEY);
        Integer step = ObjectUtil.defaultIfNull(redisProperties.getStep(), 1);
        Long aLong = (Long) valueOperations.get(key);
        if (null == aLong) {
            int value = (Integer) ObjectUtil.defaultIfNull(redisProperties.getStepStart(), 1);
            valueOperations.set(key, value);
            return value;
        } else {
            valueOperations.increment(key, step);
            return aLong;
        }
    }
}
