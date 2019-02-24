package com.example.demo;

import com.example.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//在启动该微服务的时候就去加载我们自定义的Ribbon配置类，从而使配置生效
@RibbonClient(name = "MICROSERVICECLOUD-PROVIDER-DEPT",configuration = MySelfRule.class)
public class DeptConsumer_8000_application {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_8000_application.class, args);
    }

}
