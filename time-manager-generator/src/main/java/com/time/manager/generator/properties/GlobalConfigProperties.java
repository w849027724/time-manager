package com.time.manager.generator.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author wlj
 **/
@Getter
@Setter
@Configuration
@ConfigurationProperties("global.config")
public class GlobalConfigProperties {


    private String author;

    private String model;

}
