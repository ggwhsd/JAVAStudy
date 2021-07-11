# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.1/maven-plugin/reference/html/#build-image)
* [Eureka Discovery Client](https://docs.spring.io/spring-cloud-netflix/docs/current/reference/html/#service-discovery-eureka-clients)

### Guides
The following guides illustrate how to use some features concretely:

* [Service Registration and Discovery with Eureka and Spring Cloud](https://spring.io/guides/gs/service-registration-and-discovery/)


1. 配置信息如下

```
server:
  port: 8764
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
spring:
  application:
    name: service-consumer
    
```

2. 创建service: PersonService。 如下代码调用注册中心中service-person的应用，该域名直接手动通过浏览器是无法访问的，只有通过RestTemplate类来结合eureka client来处理解析。

```
return restTemplate.getForObject("http://service-person/person/all", List.class);
```

3. 配置负载均衡，LoadBalanced会使得restTemplate的拦截器(Interceptor)中添加一个loadbalancedInteceptor，它会获取loadbalance的负载均衡功能，此时真正发出请求的是loadbalance而不是restTemplate。

```
@Bean
	@LoadBalanced
	RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
```
