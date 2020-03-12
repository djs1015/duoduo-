package com.dt87.mapper;

import com.dt87.entity.Dept;
import com.dt87.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DeptMapper {
    //查询部门
    public List<Dept> loadAllDept(@Param("dept") Dept dept);

    //生成树
    public List<Dept> loadAllDeptTreeJson(@Param("dept") Dept dept);

    //添加部门
    public int addDept(@Param("dept") Dept dept);

    //加载最大排序吗
    public int loadDeptMaxOrderNum();


}
