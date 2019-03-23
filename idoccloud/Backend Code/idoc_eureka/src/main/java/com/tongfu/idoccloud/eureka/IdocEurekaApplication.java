package com.tongfu.idoccloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//启动类
@SpringBootApplication
//注册中心
@EnableEurekaServer
public class IdocEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdocEurekaApplication.class, args);
    }

}
