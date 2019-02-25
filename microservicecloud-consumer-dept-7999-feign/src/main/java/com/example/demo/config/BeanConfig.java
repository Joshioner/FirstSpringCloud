package com.example.demo.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 这个配置类的话，就相当于applicationContext.xml
 * <bean id=" userService"  class="com.example.davie.service.UserService"></bean>
 */
@Configuration
public class BeanConfig {

    @Bean
    @LoadBalanced    //spring cloud ribbon 是基于Netflix Ribbon实现的一套客户端 负载均衡的工具
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


//    @Bean
//    public IRule myRule(){
//       // return new RandomRule();   //负载均衡算法：随机算法
//        return new RetryRule();   //负载均衡算法：先采用轮询算法，当服务不可用的时候，会重试几次，重试几次后会选择放弃这个不可用的服务
//    }
}
