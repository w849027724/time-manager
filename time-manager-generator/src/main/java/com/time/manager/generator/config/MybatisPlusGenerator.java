package com.time.manager.generator.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.time.manager.generator.properties.GlobalConfigProperties;
import com.time.manager.generator.properties.PackageConfigProperties;
import com.time.manager.generator.properties.SqlProperties;
import com.time.manager.generator.properties.StrategyConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * @author wlj
 */
@Component
@ConditionalOnBean({GlobalConfigProperties.class, PackageConfigProperties.class, SqlProperties.class, StrategyConfigProperties.class})
public class MybatisPlusGenerator {
    @Autowired
    SqlProperties sqlProperties;
    @Autowired
    GlobalConfigProperties globalConfigProperties;
    @Autowired
    StrategyConfigProperties strategyConfigProperties;
    @Autowired
    PackageConfigProperties packageConfigProperties;


    public void generate() {
        AutoGenerator mpg = new AutoGenerator();


        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();

        String projectPath = System.getProperty("user.dir");
        String outputDir = projectPath.replaceAll("time-manager-generator", globalConfigProperties.getModel());
        globalConfig.setOutputDir(outputDir + "/src/main/java");

        globalConfig.setAuthor(globalConfigProperties.getAuthor());
        globalConfig.setOpen(false);
        globalConfig.setSwagger2(true);
        globalConfig.setIdType(IdType.AUTO);

        globalConfig.setServiceName("%sService".replace("I", ""));

        mpg.setGlobalConfig(globalConfig);


        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(sqlProperties.getUrl());
        dataSourceConfig.setDriverName(sqlProperties.getDriverClassName());
        dataSourceConfig.setUsername(sqlProperties.getUsername());
        dataSourceConfig.setPassword(sqlProperties.getPassword());
        dataSourceConfig.setDbType(DbType.MYSQL);

        mpg.setDataSource(dataSourceConfig);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //strategy.setTablePrefix(new String[]{"user_"});// 此处可以修改为您的表前缀
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 需要生成的表
        String[] split = strategyConfigProperties.getTableName().split(",");
        strategy.setInclude(split);
        // 剔除公共字段
        strategy.setSuperEntityColumns("create_by", "create_time", "modified_by", "modified_time");

        strategy.setEntitySerialVersionUID(true);
        strategy.setRestControllerStyle(true);
        strategy.setEntityLombokModel(true);
        mpg.setStrategy(strategy);
//
//        // 包配置
        PackageConfig packageInfo = new PackageConfig();
        packageInfo.setParent(packageConfigProperties.getParentPath());
        mpg.setPackageInfo(packageInfo);
//
        // 自定义模板配置
        TemplateConfig template = new TemplateConfig();
        template.setService("/templates/service.java");
        template.setEntity("/templates/entity.java");
        template.setMapper("/templates/mapper.java");
//        template.setController("/templates/controller.java");
        template.setController("");
        template.setServiceImpl("/templates/serviceImpl.java");
        //template.setService()
        template.setXml("");

        mpg.setTemplate(template);


        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return outputDir + "/src/main/resources/mybatis/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        mpg.execute();

    }
}
