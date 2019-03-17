package com.tongfu.idoccloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class IdocZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdocZuulApplication.class, args);
    }

}
