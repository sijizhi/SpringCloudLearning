package com.example.mycat.service.Impl;

import com.example.mycat.entity.User;
import com.example.mycat.mapper.UserMapper;
import com.example.mycat.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public User  add(User user) throws Exception {
        userMapper.addUser(user);
     //   int i=1/0;
        return user;
    }

    @Override
    public User testDataNode(User user) throws Exception {
        return userMapper.testDataNode(user);
    }
}
