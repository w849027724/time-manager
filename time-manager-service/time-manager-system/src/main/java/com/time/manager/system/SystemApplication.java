package com.time.manager.system;

import com.time.manager.common.swagger.annotation.EnableSwagger2;
import com.time.manager.security.annotation.EnableTimeManagerSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.time.manager")
@EnableSwagger2
@EnableTimeManagerSecurity
@SpringCloudApplication
public class SystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }

}
