# time-manager

#### 介绍
    基于springCloud分布式微服务，致力于打造分布式网站，app一体的平台，用于技术学习。 
    整个项目包基于vue的后台，基于uni-app的app及小程序和基于flutter的app
#### 结构目录

time-manager
├─date                           				资料
├─time-manager-auth   				鉴权服务
├─time-manager-common 			  通用数据jar
│  ├─time-manager-common-core
│  ├─time-manager-common-mybatis 
│  ├─time-manager-common-security
│  ├─time-manager-common-sentinel
│  ├─time-manager-common-sequence
│  ├─time-manager-common-swagger
│  └─time-manager-common-xxljob
├─time-manager-extend			扩展服务
│  ├─time-manager-extend-admin
│  ├─time-manager-extend-sentinel
│  └─time-manager-extend-xxljob
├─time-manager-gateway			网关
├─time-manager-generator		代码生成器
└─time-manager-service			应用服务
    ├─time-manager-cms
    ├─time-manager-cms-api
    ├─time-manager-system		系统应用服务
    ├─time-manager-system-api	系统应用服务feign的api
    ├─time-manager-wallet
    └─time-manager-wallet-api

#### 使用的技术

后端：
微服务组件：openFeign，hystrix
网关：springCloud Gateway
注册配置中心：nacos
接口文档：swagger
降级限流：sentinel
服务监控：spring-boot-admin
分布式事物：seata
分布式任务调度：xxlJob
分库分表（进行中）：sharding-jdbc

前端：
基于vue3后台
app:
flutter
小程序：
uni-app

#### 目前进度
1.ui收集
2.flutter搭建
3.后台搭建 