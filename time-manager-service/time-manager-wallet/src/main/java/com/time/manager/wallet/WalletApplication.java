package com.time.manager.wallet;

import com.time.manager.common.swagger.annotation.EnableSwagger2;
import com.time.manager.security.annotation.EnableTimeManagerSecurity;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableSwagger2
@EnableTimeManagerSecurity
@SpringCloudApplication
public class WalletApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalletApplication.class, args);
    }

}
