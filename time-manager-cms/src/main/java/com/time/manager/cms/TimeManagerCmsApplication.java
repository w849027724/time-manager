package com.time.manager.cms;

import com.time.manager.common.swagger.annotation.EnableSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wlj
 */
@EnableSwagger2
@SpringBootApplication
public class TimeManagerCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeManagerCmsApplication.class, args);
    }

}
