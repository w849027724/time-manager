package com.time.manager.common.xxljob.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author wlj
 **/
@Data
@Configuration
@ConfigurationProperties("xxl.job")
public class XxlJobProperties {

    private Boolean enabled;

    private String adminAddresses;

    private String accessToken;

    private String appname;

    private String address;

    private int port;

    private String ip;

    private String logPath;

    private int logRetentionDays;


}
