package com.time.manager.cms;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
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
@NacosPropertySource(dataId = "time-manager-cms", autoRefreshed = true)
public class CmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }

}
