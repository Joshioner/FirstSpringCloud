package com.example.demo.service;

import com.example.demo.entity.Dept;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);

    public Dept getDept(Integer id);

    public List<Dept> findAll();
}
