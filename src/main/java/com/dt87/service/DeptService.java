package com.dt87.service;

import com.dt87.entity.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptService {
    public List<Dept> loadAllDept(Dept dept);

    public List<Dept> loadAllDeptTreeJson(Dept dept);

    public int addDept(Dept dept);

    public Integer loadDeptMaxOrderNum();

}
