package com.time.manager.cms;

import com.time.manager.common.swagger.annotation.EnableSwagger2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wlj
 */
@MapperScan("com.time.**.mapper")
@EnableSwagger2
@SpringBootApplication
public class TimeManagerCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeManagerCmsApplication.class, args);
    }

}
