# time-manager

#### 介绍
    基于springCloud分布式微服务，致力于打造分布式网站，app一体的平台，用于技术学习。 
    整个项目包基于vue的后台，基于uni-app的app及小程序和基于flutter的app
#### 结构目录

time-manager<br>
├─date                   			资料      <br>
├─time-manager-auth   			   鉴权服务   <br>
├─time-manager-common 			  通用数据jar<br>
│  ├─time-manager-common-core<br>
│  ├─time-manager-common-mybatis <br>
│  ├─time-manager-common-security<br>
│  ├─time-manager-common-sentinel<br>
│  ├─time-manager-common-sequence<br>
│  ├─time-manager-common-swagger<br>
│  └─time-manager-common-xxljob<br>
├─time-manager-extend			扩展服务<br>
│  ├─time-manager-extend-admin<br>
│  ├─time-manager-extend-sentinel<br>
│  └─time-manager-extend-xxljob<br>
├─time-manager-gateway			网关<br>
├─time-manager-generator		代码生成器<br>
└─time-manager-service			应用服务<br>
    ├─time-manager-cms<br>
    ├─time-manager-cms-api<br>
    ├─time-manager-system		系统应用服务<br>
    ├─time-manager-system-api	系统应用服务feign的api<br>
    ├─time-manager-wallet<br>
    └─time-manager-wallet-api<br>

#### 使用的技术

后端：<br>
微服务组件：openFeign，hystrix<br>
网关：springCloud Gateway<br>
注册配置中心：nacos<br>
接口文档：swagger<br>
降级限流：sentinel<br>
服务监控：spring-boot-admin<br>
分布式事物：seata<br>
分布式任务调度：xxlJob<br>
分库分表（进行中）：sharding-jdbc<br>

前端：<br>
基于vue3后台<br>
app:<br>
flutter<br>
小程序：<br>
uni-app<br>

#### 目前进度
1.ui收集<br>
2.flutter搭建<br>
3.后台搭建 <br>