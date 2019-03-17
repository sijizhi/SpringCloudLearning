package com.tongfu.cloud.idoc_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class IdocEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdocEurekaApplication.class, args);
    }

}
