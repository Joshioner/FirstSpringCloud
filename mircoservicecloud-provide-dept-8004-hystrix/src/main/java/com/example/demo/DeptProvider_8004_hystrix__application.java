package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient   //表明这个一个eureka客户端，向eureka注册服务
@EnableHystrix   //表面开启Hystrix熔断降级服务
public class DeptProvider_8004_hystrix__application {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8004_hystrix__application.class,args);
    }
}
