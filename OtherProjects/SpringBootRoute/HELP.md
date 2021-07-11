# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.1/maven-plugin/reference/html/#build-image)

### Guides
The following guides illustrate how to use some features concretely:

* [Using Spring Cloud Gateway](https://github.com/spring-cloud-samples/spring-cloud-gateway-sample)


springboot(2.5.1.RELEASE)，spring cloud(2020.0.3)。

* 路由注意 *

```
filters:
- StripPrefix=1
```

如上加上StripPrefix过滤器，在转发url时，才会把原有的匹配前缀去掉，比如示例中 输入 http://localhost:9001/h1/hellos/hello1 路由之后为http://localhost:9000/hellos/hello1

* PrefixPath 过滤器 ：它的作用和StripPrefix正相反，是在URL路径前面添加一部分的前缀
* 

参考：https://www.jianshu.com/p/5e40bbc95eb9

* 关于过滤器 *
Spring Cloud Gateway内置了19种强大的过滤器工厂，能够满足很多场景的需求，但是也可以自定义过滤器，[示例](./src/main/java/com/studyspringcloud/filter/ElapsedFilter.java)
在启动类中添加如下，表示启用自定义的过滤器来统计提交请求pre和post之间的耗时，并且将请求/h2/**的路由设置到http://localhost:9001/hellos/hello1路径下。
```
@Bean
	public RouteLocator customerRouteLocator(RouteLocatorBuilder builder)
	{
		return builder.routes()
				.route(r->r.path("/h2/**")
						.filters(f->f.stripPrefix(1)
								.filter(new ElapsedFilter())
								.addResponseHeader("X-Response-Default-Foo", "Default-Bar")
								.setPath("/hellos/hello1")
								)
						.uri("http://localhost:9001")
						)
				.build();
	}
```

* http客户端：feign组件 *
在pom中添加配置，然后调用feign组件。[示例](./src/main/java/com/studyspringcloud/service/FeignService.java)
添加controller来调用service[示例](./src/main/java/com/studyspringcloud/controller/FeignController.java)
但是还是有无法正常提供服务，注入有问题。后来换了springboot和spring cloud的版本，就可以了。
springboot(2.0.4.RELEASE)，spring cloud(Finchley.RELEASE)。



* 负载均衡组件：ribbon *

1. pom添加
```
 <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
        </dependency>
```
2. 注入

```
  //为了使用ribbon的功能
	@Bean
    @LoadBalanced
    RestTemplate restTemplate() {

        return new RestTemplate();
    }
```

3. 新建一个controller，

```
@RestController
public class RibbonController {
	@Resource
    private RestTemplate restTemplate;
	@GetMapping("/loadbalanceuseribbon")
    public String loadbalanceuseribbon() {

        return this.restTemplate.getForObject("http://serviceprovider", String.class);
    }
}
```

4. 配置application.properties中负载网址，用逗号隔开。测试的是http的正常，对于https的会报错。
serviceprovider.ribbon.listOfServers:localhost:8080,localhost:8081











