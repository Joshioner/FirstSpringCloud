package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient   //表明这个一个eureka客户端，向eureka注册服务
public class DeptProvider_8001_application {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8001_application.class,args);
    }
}
