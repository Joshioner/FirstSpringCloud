package com.example.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * 自定义负载均衡算法：必须不能放在主启动类所在的包以及子包下，否则我们自定义的配置类就会被所有的Ribbon客户端所共享，也就是说达不到我们特殊化定制的目的了
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
       // return new RandomRule();  //随机算法
        return new RandomRule_Davie(); //自定义的随机算法，每个微服务轮询5次
    }
}
