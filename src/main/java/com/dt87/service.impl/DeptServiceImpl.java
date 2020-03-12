package com.dt87.service.impl;

import com.dt87.entity.Dept;
import com.dt87.mapper.DeptMapper;
import com.dt87.service.DeptService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    //查询部门
    public List<Dept> loadAllDept(@Param("dept") Dept dept) {
        System.out.println(123);
        return deptMapper.loadAllDept(dept);
    }

    @Override
    public List<Dept> loadAllDeptTreeJson(Dept dept) {
        return deptMapper.loadAllDeptTreeJson(dept);
    }

    //添加部门
    @Override
    public int addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    //最大排序吗
    @Override
    public Integer loadDeptMaxOrderNum() {
        return deptMapper.loadDeptMaxOrderNum();
    }


}
