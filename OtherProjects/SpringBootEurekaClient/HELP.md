# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.1/maven-plugin/reference/html/#build-image)


配置eureka的客户端，只有两步：

1. 配置服务中心的地址，方便连接服务中心。
```
eureka.client.serviceUrl.defaultZone = http://localhost:8761/eureka/
server.port = 8762
spring.application.name= service-person
```

2. 启动类上加上@EnableEurekaClient注解。

此时，在服务中心的http://127.0.0.1:8761/上可以看到当前service-person的状态为up。