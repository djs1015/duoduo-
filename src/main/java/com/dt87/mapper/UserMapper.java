package com.dt87.mapper;

import com.dt87.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    //查询用户
    public User findByName(@Param("username") String username);

    //用户登录
    public User login(@Param("username") String username, @Param("password") String password);


}
