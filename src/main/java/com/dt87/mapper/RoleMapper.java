package com.dt87.mapper;

import com.dt87.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RoleMapper {
    //查询角色
    public List<Role> finfByRid(@Param("rid") int rid);
}
