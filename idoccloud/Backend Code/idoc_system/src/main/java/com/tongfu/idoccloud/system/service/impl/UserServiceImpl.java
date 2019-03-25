package com.tongfu.idoccloud.system.service.impl;

import com.tongfu.idoccloud.system.entity.User;
import com.tongfu.idoccloud.system.mapper.UserMapper;
import com.tongfu.idoccloud.system.service.UserService;
import com.tongfu.idoccloud.system.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/3/12 15:54
 */
@Service
public class UserServiceImpl implements UserService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    @Resource
    private UserMapper userMapper;
    @Autowired
    private RedisClient redisClient;
    @Autowired
    private JwtUtil jwtUtil;
    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        String loginPass=user.getPassword();
        String ip=user.getIp();
        String deviceNumber=user.getDeviceNumber();

        System.out.println("loginpass>>"+passwordEncoder.encode(loginPass));
        user=userMapper.login(user);
        if(!StringUtils.isEmpty(user)){
            //比较密码是否正确
            if(passwordEncoder.matches(loginPass,user.getPassword())){
                user.setPassword("");
                String db_name=DbUtil.getDbName();
                user.setDb_name(db_name);
                user.setIp(ip);
                user.setDeviceNumber(deviceNumber);
                //              String token= jwtUtil.encode(user, 1000*60*60*24);
                String token= jwtUtil.encode(user, 1000*60*60*24*365);
                //保存登录信息30分钟
//                redisClient.set(db_name+":login:token:"+user.getUserCode(), token, 60*30);
                redisClient.set(db_name+":login:token:"+user.getUserCode(), token);
                System.out.println("token>>>>"+token);
                user.setIdoc_token(token);
                user.setDb_name("");
                return user;
            }else{
                return new User();
            }

        }


        return user;
    }

    /**
     * 检测密码
     * @param user
     * @return
     */
    @Override
    public boolean checkPassword(User user) {
        String oldPass=user.getPassword();
        user=userMapper.login(user);
        //比较密码是否正确
        if(passwordEncoder.matches(oldPass, user.getPassword())){
            return true;
        }
        return false;
    }


    /**
     * 修改初始密码
     * @param user
     * @return
     */
    @Override
    public boolean changeInitPass(User user) {
        user.setUpdateDate(new Date());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if(userMapper.changeInitPass(user)==1){

            return true;
        }
        return false;
    }
}
