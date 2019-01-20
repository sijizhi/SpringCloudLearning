package com.example.mycat.controller;

import com.example.mycat.entity.User;
import com.example.mycat.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/1/16 14:06
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/testMycat")
    public List<User> allUsers(){
        List<User> list=new ArrayList<>();
        try {
            list=userService.allUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  list;
    }

    @RequestMapping("/addUser")
    public User addUser(User user)throws Exception{

        return userService.add(user);
    }
}
