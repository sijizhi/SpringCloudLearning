package com.tongfu.idoccloud.preposition.task;

import com.tongfu.idoccloud.preposition.entity.LoggerEntity;
import com.tongfu.idoccloud.preposition.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/3/18 16:09
 */
@Component
@Async
public class LoggerAsync {

    @Autowired
    private LoggerService loggerService;
    public Future<String> addOperation(LoggerEntity loggerEntity)  {

        loggerService.addOperation(loggerEntity);

        return new AsyncResult<>("异步任务-logger");
    }

}
