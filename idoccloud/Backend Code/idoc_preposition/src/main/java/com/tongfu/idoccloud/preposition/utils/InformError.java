package com.tongfu.idoccloud.preposition.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/3/13 16:28
 */
@Component
public class InformError {
    @Autowired
    private RedisClient redisClient;

    public void sendInform(String redisKey,String question){
        String keyValue = redisClient.get(redisKey);
        //模拟发现短信通知
        if (StringUtils.isEmpty(keyValue)) {
            System.out.println("短信提示："+question);
            redisClient.set(redisKey, question+"，请及时修复！", 60);
        } else {
            System.out.println("短信已发送，60秒后再次发送");
        }
    }}
