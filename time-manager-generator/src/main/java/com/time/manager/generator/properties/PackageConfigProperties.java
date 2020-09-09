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
@ConfigurationProperties("package.config")
public class PackageConfigProperties {
    private String bizModule;
    private String parentPath;

}
