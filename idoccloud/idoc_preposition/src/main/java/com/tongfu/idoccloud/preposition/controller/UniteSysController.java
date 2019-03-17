package com.tongfu.idoccloud.preposition.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.rabbitmq.tools.json.JSONUtil;
import com.tongfu.idoccloud.preposition.entity.User;
import com.tongfu.idoccloud.preposition.enums.ResponseEnums;
import com.tongfu.idoccloud.preposition.feign.system.SystemFeign;
import com.tongfu.idoccloud.preposition.utils.CookieUtil;
import com.tongfu.idoccloud.preposition.utils.JsonUtil;
import com.tongfu.idoccloud.preposition.utils.ResponseUtil;
import com.tongfu.idoccloud.preposition.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 前置服务 统一接口
 * @Author: Sijie Zhi
 * @Date: 2019/3/12 16:51
 */
@RequestMapping("/uniteapi/sys/v1")
@RestController
public class UniteSysController {

    Logger logger= LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "/test")
    public String test(String usercode){

        return "测试成功:usercode>>"+usercode;
    }



    @Autowired
    private SystemFeign systemFeign;

    /**
     *登录接口
     * @param user
     * @return
     */
    @PostMapping("/usr/login")
    public ResponseVO login(User user){
        user=systemFeign.login(user,user.getDb_name());
        System.out.println(user.getDb_name());
        return ResponseUtil.success(user);
    }

    /**
     *系统- 用户统一接口
     * @param map
     * @return
     */
    @PostMapping("/usr/operation")
    public ResponseVO unite1(@RequestParam Map<String,Object> map){
        System.out.println(map.toString());
        String operation=map.get("operation").toString();
        //检测密码
        if(operation.equals("checkPassword")){
            User user=JSON.parseObject(JSONArray.toJSONString(map),User.class);
            return ResponseUtil.success(systemFeign.checkPassword(user,user.getDb_name()));
        }
        return ResponseUtil.error(ResponseEnums.ERROR);
    }

}
