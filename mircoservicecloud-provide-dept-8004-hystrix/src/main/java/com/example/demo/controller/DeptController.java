package com.example.demo.controller;

import com.example.demo.entity.Dept;
import com.example.demo.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "get_null_dept")
    public Dept getDept(@PathVariable("id")Integer id){
        System.out.println("*******---------8004--------*****");
        Dept dept = deptService.getDept(id);
        if (dept == null){
            throw new RuntimeException("id的部门不存在");
        }
        return dept;
    }

    @GetMapping("/dept/list")
    public List<Dept> findAll(){
        return deptService.findAll();
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

    public Dept get_null_dept(@PathVariable("id")Integer id){
        return new Dept().setId(id).setDeptName("该id:" + id + "没有对应的信息，不存在").setDbSource("no database in mysql");
    }
}
