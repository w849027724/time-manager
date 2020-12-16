package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author wlj
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "sentinel.nacos")
public class NacosPropertiesConfiguration {
    private String serverAddr;
    private String dataId;
    private String groupId = "SENTINEL_GROUP"; // 默认分组
    private String namespace;
}
