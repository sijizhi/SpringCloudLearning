package com.example.mycat.service;

import com.example.mycat.entity.User;

import java.util.List;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/1/16 13:58
 */
public interface UserService {
    public List<User> allUsers() throws Exception;
}
