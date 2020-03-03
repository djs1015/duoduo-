package com.dt87.service;

import com.dt87.entity.Dept;

import java.util.List;

public interface DeptService {
    public List<Dept> loadAllDept(Dept dept);
}
