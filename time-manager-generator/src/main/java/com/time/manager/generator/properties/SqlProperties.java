package com.time.manager.generator.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author wlj
 **/
@Getter
@Setter
@Configuration
@ConfigurationProperties("spring.datasource")
public class SqlProperties {

    private String url;

    private String username;

    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

}
