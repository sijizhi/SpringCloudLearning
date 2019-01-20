package com.example.mycat.mapper;

import com.example.mycat.entity.User;

import java.util.List;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/1/16 14:01
 */
public interface UserMapper {
    public List<User> allUsers();
    public int  addUser(User user);
}
