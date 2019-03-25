package com.tongfu.idoccloud.system.controller;

import com.tongfu.idoccloud.system.entity.User;
import com.tongfu.idoccloud.system.service.UserService;
import com.tongfu.idoccloud.system.utils.MapVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/3/12 15:49
 */
@RestController
@RequestMapping("/api/user/v1")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Object login(User  user){
        System.out.println("》》》》》》》》》》》》》》》》》测试拉拉"+user);
        return  userService.login(user);
    }

    /**
     * 检测密码
     * @param user
     * @return
     */
    @PostMapping("/checkPassword")
    public Object checkPassword( User user){
        System.out.println("》》》》》》》》》》》》》》》》》checkPassword"+user);
        return MapVo.returnMap("result", userService.checkPassword(user));
    }

    /**
     * 修改初始密码
     * @param user
     * @return
     */
    @PostMapping("/changeInitPass")
    public Object changeInitPass( User user){
        System.out.println("》》》》》》》》》》》》》》》》》changeInitPass"+user);
        return MapVo.returnMap("result", userService.changeInitPass(user));
    }

}