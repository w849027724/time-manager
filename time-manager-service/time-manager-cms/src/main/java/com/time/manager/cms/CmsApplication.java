package com.time.manager.cms;

import com.time.manager.common.swagger.annotation.EnableSwagger2;
import com.time.manager.security.annotation.EnableTimeManagerSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wlj
 */
@EnableFeignClients(basePackages = "com.time.manager")
@EnableSwagger2
@EnableTimeManagerSecurity
@SpringCloudApplication
public class CmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }

}
