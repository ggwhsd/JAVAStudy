package com.studyspringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.studyspringcloud.filter.ElapsedFilter;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.client.RestTemplate;
@EnableFeignClients
@SpringBootApplication
public class SpringBootRouteApplication {

	//代码方式配置网关路由以及使用的自定义过滤器。
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
	
	//为了使用ribbon的功能
	@Bean
    @LoadBalanced
    RestTemplate restTemplate() {

        return new RestTemplate();
    }
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootRouteApplication.class, args);
	}

}
