package com.example.pagehelper.controller;

import com.example.pagehelper.entity.PageResultBean;
import com.example.pagehelper.entity.User;
import com.example.pagehelper.service.UserService;
import com.example.pagehelper.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Sijie Zhi
 * @Date: 2018/12/20 11:45
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUsers")
    public PageResultBean<User> pageUesr(int currentPage, int pageSize)throws Exception{

        return new PageResultBean<User>(userService.listUser( currentPage, pageSize));
    }
    @RequestMapping("/adduser")
    public ResultData addUser(User user)throws  Exception{
       if( userService.addUser(user)==1){
           return new ResultData(200,"成功");
       };
        return new ResultData(401,"请求失败");
    }

}
