package com.dt87.service;

import com.dt87.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    public User findByName(String username);

    public User login(String username, String password);
}
