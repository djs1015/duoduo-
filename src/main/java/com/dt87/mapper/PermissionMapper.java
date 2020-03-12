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

    //查看所有权限（并生成树）
    public List<Permission> loadAllMenuTreeJson(@Param("permission") Permission permission);

    //查询所有权限内容
    public List<Permission> loadAllPermission(@Param("permission") Permission permission);

    //添加权限
    public int addPermission(@Param("permission") Permission permission);

    //最大排序码
    public int loadPermissionMaxOrderNum();

    //删除一条数据
    public Integer deletePermission(@Param("id") Integer id);
}
