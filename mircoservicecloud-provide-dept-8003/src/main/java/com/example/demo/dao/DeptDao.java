package com.example.demo.dao;

import com.example.demo.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept getDept(Integer id);

    public List<Dept> findAll();
}
