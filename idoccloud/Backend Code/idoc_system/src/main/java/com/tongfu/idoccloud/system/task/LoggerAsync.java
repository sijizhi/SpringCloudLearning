package com.tongfu.idoccloud.system.task;

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

    public Future<String> addOperation() throws InterruptedException {

        return new AsyncResult<>("异步任务-logger");
    }

}
