package com.time.manager.generator;


import com.time.manager.generator.config.MybatisPlusGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExtApplicationTests {
    @Autowired
    MybatisPlusGenerator mybatisplusGenerator;

    /**
     * 代码生成器
     */
    @Test
    public void generateCode() {
        mybatisplusGenerator.generate();
    }

}
