# RuoYi-Boot-Vue 使用创建示例项目
重构后的 RuoYi-Vue-Plus 采用了类似于 Spring Boot 的使用方式，开发者只需在项目中引入相应的依赖，即可快速启动开发工作。这种设计降低了学习和使用的门槛，使得项目能够更好地适应未来业务和技术的变化。

模块化开发模式，后续将把所开发的模块都发布到了maven中央库，也可本地把源代码clone下来，然后通过
```shell
maven clean install
```
命令安装到本地maven仓库，再通过类似于 Spring Boot 的使用方式来进行项目搭建。 

**以示例方式是以继承ruoyi-boot-starter-parent方式搭建项目**
```XML
<parent>
    <groupId>org.dromara.boot</groupId>
    <artifactId>ruoyi-boot-starter-parent</artifactId>
    <version>5.2.1</version>
</parent>
```
支持扫描不同包，即自己公司或域名的包命名，使用方式如下：

1.需要配置MyBatisPlus mapper domain多包扫描。
```yml
mybatis-plus:
  # 多包名使用 例如 org.dromara.**.mapper,org.xxx.**.mapper
  mapperPackage: org.dromara.**.mapper,cc.dhf.**.mapper
  # 实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: org.dromara.**.domain,cc.dhf.**.domain
```

2.启动的时候设置RuoYiApplicationContextInitializer，为了扫描RuoYi-Boot-Vue项目的包。
```java
/**
* Admin启动程序
  */
  @SpringBootApplication
  public class AdminApplication {

  public static void main(String[] args) {
  SpringApplication application = new SpringApplication(AdminApplication.class);
  application.setApplicationStartup(new BufferingApplicationStartup(2048));
  application.addInitializers(new RuoYiApplicationContextInitializer());
  application.run(args);
  System.out.println("(♥◠‿◠)ﾉﾞ  Admin启动成功   ლ(´ڡ`ლ)ﾞ");
  }

}
```