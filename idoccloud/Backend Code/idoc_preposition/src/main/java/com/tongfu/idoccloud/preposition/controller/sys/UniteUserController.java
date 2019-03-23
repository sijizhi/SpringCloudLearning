package com.tongfu.idoccloud.preposition.controller.sys;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.tongfu.idoccloud.preposition.entity.LoggerEntity;
import com.tongfu.idoccloud.preposition.entity.User;
import com.tongfu.idoccloud.preposition.enums.ResponseEnums;
import com.tongfu.idoccloud.preposition.feign.system.UserFeign;
import com.tongfu.idoccloud.preposition.service.LoggerService;
import com.tongfu.idoccloud.preposition.utils.JsonUtil;
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
public class UniteUserController {

    Logger logger= LoggerFactory.getLogger(this.getClass());



    @Autowired
    private UserFeign systemFeign;
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
        loggerEntity.setDeviceNumber(user.getDeviceNumber());
        loggerEntity.setOperation("login");
        try{
             user=JSON.parseObject(JSONArray.toJSONString(systemFeign.login(user.getUserCode(),
                    user.getPassword(),user.getIp(),user.getDeviceNumber(),
                    user.getDb_name())),User.class);
            if(!StringUtils.isEmpty(user)&&user.getUserId()!=null){
                if(user.getUserId()!=0){
                    loggerEntity.setUserId(user.getUserId());
                    loggerEntity.setDepartId(user.getDepartId());
                    loggerEntity.setUserName(user.getChineseName());
                    loggerService.addOperation(loggerEntity);
                    return ResponseUtil.success(user);
                }else{
                    return ResponseUtil.error(500,"服务器繁忙，请稍后再试！" );
                }

            }
            //用户为空-账号密码不对
            {
                return ResponseUtil.error(700,"用户名或密码不正确！" );
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("执行操作operation=login有误");
            return ResponseUtil.error(ResponseEnums.ERROR);
        }
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
        System.out.println("operation>>>>>>>>>>>"+operation);
        try{
            /**
             *  检测密码
             */

            if(operation.equals("checkPassword")){
                User user=JSON.parseObject(JSONArray.toJSONString(map),User.class);
                return ResponseUtil.success(systemFeign.checkPassword(user.getUserCode(),
                        user.getPassword(),
                        user.getIdoc_token()));
            }
            /**
             *  修改初始密码
             */

            else if(operation.equals("changeInitPass")){
                User user=JSON.parseObject(JSONArray.toJSONString(map),User.class);
                return ResponseUtil.success(systemFeign.changeInitPass(user.getUserCode(),
                        user.getPassword(),
                        user.getIdoc_token()));
            }
            /**
             *  修改密码
             */
            else if(operation.equals("updatePass")){
                User user=JSON.parseObject(JSONArray.toJSONString(map),User.class);
                return ResponseUtil.success(systemFeign.changeInitPass(user.getUserCode(),
                        user.getPassword(),
                        user.getIdoc_token()));
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("执行操作operation="+operation+"有误");
            return ResponseUtil.error(ResponseEnums.ERROR);
        }

        return ResponseUtil.error(ResponseEnums.ERROR);
    }




}
