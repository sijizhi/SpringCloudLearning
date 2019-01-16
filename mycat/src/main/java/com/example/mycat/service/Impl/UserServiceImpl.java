package com.example.mycat.service.Impl;

import com.example.mycat.entity.User;
import com.example.mycat.mapper.UserMapper;
import com.example.mycat.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/1/16 13:58
 */
@Component
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> allUsers() throws Exception {
        return userMapper.allUsers();
    }
}
