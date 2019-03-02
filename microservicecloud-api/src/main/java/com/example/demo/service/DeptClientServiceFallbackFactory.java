package com.example.demo.service;

import com.example.demo.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 重写FallbackFactory 接口，将异常处理的方法单独提取出来，类似于spring aop
 */
@Component  //这个注解一定要添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept getDept(Integer id) {
                return new Dept().setId(id).setDeptName("这是一个来自于降级的回应").setDbSource("no database is selected");
            }

            @Override
            public List<Dept> findAll() {
                return null;
            }

            @Override
            public Object discover() {
                return null;
            }
        };
    }
}
