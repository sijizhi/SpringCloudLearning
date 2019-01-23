package com.example.pagehelper.mapper;

import com.example.pagehelper.entity.User;

import java.util.List;

/**
 * @Author: Sijie Zhi
 * @Date: 2018/12/20 11:48
 */
public interface UserMapper {
    public List<User> pageUsers();
    public int addUser(User user);
}
