package com.tongfu.idoccloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
//启动类
@SpringBootApplication
//配置中心
@EnableConfigServer
public class IdocConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdocConfigApplication.class, args);
    }

}
