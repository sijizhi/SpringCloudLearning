package com.tongfu.idoccloud.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.tongfu.idoccloud.system.mapper" })
public class IdocSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdocSystemApplication.class, args);
    }

}
