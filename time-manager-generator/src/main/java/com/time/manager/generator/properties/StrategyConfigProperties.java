package com.time.manager.generator.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author wlj
 **/
@Getter
@Setter
@Configuration
@ConfigurationProperties("strategy.config")
public class StrategyConfigProperties {

    private String superEntityClass;

    private String tableName;

}
