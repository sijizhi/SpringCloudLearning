package com.tongfu.idoccloud.preposition.service.impl;

import com.tongfu.idoccloud.preposition.entity.LoggerEntity;
import com.tongfu.idoccloud.preposition.mapper.LoggerMapper;
import com.tongfu.idoccloud.preposition.service.LoggerService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/3/19 10:50
 */
@Service
public class LoggerServiceImpl implements LoggerService {

    @Resource
    private LoggerMapper loggerMapper;

    @Override
    public int addOperation(LoggerEntity loggerEntity) {
        loggerEntity.setCreateDate(new Date());
        String operations=loggerEntity.getOperation();
        //校验密码（不用加入日志）
        if(operations.equals("checkPassword")){
            loggerEntity.setDescription("校验密码");
        }else if(operations.equals("login")){
            loggerEntity.setDescription("登录");
        }

        return loggerMapper.addLogger(loggerEntity);
    }

}
