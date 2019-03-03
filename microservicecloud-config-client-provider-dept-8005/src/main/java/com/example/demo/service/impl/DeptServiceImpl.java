package com.example.demo.service.impl;

import com.example.demo.dao.DeptDao;
import com.example.demo.entity.Dept;
import com.example.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;
    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept getDept(Integer id) {
        return deptDao.getDept(id);
    }

    @Override
    public List<Dept> findAll() {
        return deptDao.findAll();
    }
}
