package com.example.demo.controller;

import com.example.demo.entity.Dept;
import com.example.demo.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptFeignController {

    @Autowired
    private DeptClientService deptClientService;

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptClientService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept getDept(@PathVariable("id")Integer id){
        System.out.println("*******---------8002--------*****");
        return deptClientService.getDept(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> findAll(){
        return deptClientService.findAll();
    }

    //服务发现
    @GetMapping("/dept/discover")
    public Object discover(){
        //获取所有的服务
        List<String> serviceList = client.getServices();
        System.out.println("***********" + serviceList + "**********");

        List<ServiceInstance> serviceInstances = client.getInstances("MICROSERVICECLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance:serviceInstances){
            System.out.println(instance.getHost() + "\t" + instance.getServiceId() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.client;
    }
}
