package com.example.demo.service;

import com.example.demo.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "MICROSERVICECLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
    @PostMapping("/dept/add")
    public boolean addDept(Dept dept);

    @GetMapping("/dept/get/{id}")
    public Dept getDept(@PathVariable("id")Integer id);


    @GetMapping("/dept/list")
    public List<Dept> findAll();

    //服务发现
    @GetMapping("/dept/discover")
    public Object discover();
}

