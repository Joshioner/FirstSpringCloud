package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class DeptConsumer_7999_application_feign {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_7999_application_feign.class, args);
    }

}
