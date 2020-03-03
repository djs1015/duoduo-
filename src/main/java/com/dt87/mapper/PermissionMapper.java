package com.dt87.mapper;

import com.dt87.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PermissionMapper {
    //查询权限
    public List<Permission> findByPid(@Param("pid") int pid);

    //加载目录
    public List<Permission> loadMenu();
}
