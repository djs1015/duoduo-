package com.dt87.mapper;

import com.dt87.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
@Mapper
public interface RoleMapper {
    //查询角色
    public List<Role> finfByRid(@Param("rid") int rid);

    //查询所有角色
    public List<Role> loadAllRole(@Param("role") Role role);

    //添加角色
    public int addRole(@Param("role") Role role);
    //修改角色
    public int updateRole(@Param("role") Role role);
    //批量删除
    public int batchDeleteRole(@Param("list") List<Serializable> list);
    //给角色分配权限（让该角色拥有这个权限，也就是说添加到sys_role_permission表中）
    public int saveRolePermission(@Param("role") Role role);
}
