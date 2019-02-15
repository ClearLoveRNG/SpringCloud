package com.example.eurekaribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableHystrix开启Hystrix断路器x
@EnableHystrix
//@EnableEurekaClient表示自己是个Eureka客户端，提供服务
@EnableEurekaClient
//@EnableDiscoveryClient表示该应用注册为Eureka客户端应用，拥有发现服务器服务的功能
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaRibbonApplication.class, args);
	}

    /**
     * Spring cloud有两种服务调用方式，一种是ribbon+restTemplate，另一种是feign,
     * 先说第一种，restTemplate是用来发送请求的，这里直接在SpringBoot启动的时候就注入bean：RestTemplate
     * 并通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能。
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

