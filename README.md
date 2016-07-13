## spring-boot-starter-dubbox

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.cjoop/spring-boot-starter-dubbox/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.cjoop/spring-boot-starter-dubbox)

spring-boot自动集成dubbox默认配置,添加以下依赖：

```sh
<dependency>
			<groupId>com.cjoop</groupId>
			<artifactId>spring-boot-starter-dubbox</artifactId>
			<version>0.0.1</version>
</dependency>
```

application.properties配置和dubbo.properties配置一致，写法如下：

```sh
#DUBBO
dubbo.application.name=xx-service
dubbo.registry.address=zookeeper://localhost:2181
dubbo.annotation.package=com.xx.service
```
