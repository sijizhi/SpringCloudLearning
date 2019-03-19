package com.tongfu.idoccloud.preposition.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.tongfu.idoccloud.preposition.entity.LoggerEntity;
import com.tongfu.idoccloud.preposition.entity.User;
import com.tongfu.idoccloud.preposition.enums.ResponseEnums;
import com.tongfu.idoccloud.preposition.feign.system.SystemFeign;
import com.tongfu.idoccloud.preposition.service.LoggerService;
import com.tongfu.idoccloud.preposition.task.LoggerAsync;
import com.tongfu.idoccloud.preposition.utils.ResponseUtil;
import com.tongfu.idoccloud.preposition.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private LoggerService loggerService;

    /**
     *登录接口
     * @param user
     * @return
     */
    @PostMapping("/usr/login")
    public ResponseVO login(User user){
        LoggerEntity loggerEntity=new LoggerEntity();
        loggerEntity.setRequestApi("/uniteapi/sys/v1/usr/login");
        loggerEntity.setRequestService("system-service");
        loggerEntity.setUserIp(user.getIp());
        loggerEntity.setOperation("login");
        user=systemFeign.login(user.getUserCode(),
                user.getPassword(),
                user.getDb_name());
        if(!StringUtils.isEmpty(user.getUserId())){
            loggerEntity.setUserId(user.getUserId());
            loggerEntity.setDepartId(user.getDepartId());
            loggerEntity.setUserName(user.getChineseName());
            loggerService.addOperation(loggerEntity);
        }
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
            return ResponseUtil.success(systemFeign.checkPassword(user.getUserCode(),
                    user.getPassword(),
                    user.getIdoc_token()));
        }
        return ResponseUtil.error(ResponseEnums.ERROR);
    }

}
