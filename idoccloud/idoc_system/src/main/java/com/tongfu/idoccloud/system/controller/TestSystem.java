package com.tongfu.idoccloud.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/3/7 16:00
 */
@RestController
@RequestMapping("/api/v1/sys")
public class TestSystem {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/systest")
    public String systest(String text){
        logger.info("system service");
        return "我是小植呀>>>>"+text;
    }
}
