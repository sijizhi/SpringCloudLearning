package com.example.pagehelper.service.Impl;

import com.example.pagehelper.entity.User;
import com.example.pagehelper.mapper.UserMapper;
import com.example.pagehelper.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Sijie Zhi
 * @Date: 2018/12/20 11:47
 */
@Component
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> listUser(int currentPage,int pageSize) throws Exception {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);
        List<User> listUser=userMapper.pageUsers();

        return listUser;
    }

    @Override
   @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public int addUser(User user) throws Exception {
        user=new User(user.getUserCode(),user.getUserCode(),user.getUserCode(),user.getUserCode());
        userMapper.addUser(user);
        int i=1/0;
        return userMapper.addUser(user);
    }
}
