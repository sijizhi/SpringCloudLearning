package com.example.pagehelper.service;

import com.example.pagehelper.entity.PageResultBean;
import com.example.pagehelper.entity.User;

import java.util.List;

/**
 * @Author: Sijie Zhi
 * @Date: 2018/12/20 11:46
 */
public interface UserService {
    public List<User> listUser(int currentPage, int pageSize) throws Exception;
    public int addUser(User user) throws Exception;
}
