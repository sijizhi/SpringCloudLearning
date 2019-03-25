package com.tongfu.idoccloud.preposition;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients //服务间的通讯 feign （ribbon）
//@EnableCircuitBreaker //熔断降级（断路器） hystrix用到
//@EnableHystrixDashboard//断路器 仪表\
@EnableAsync
@MapperScan(basePackages = {"com.tongfu.idoccloud.preposition.mapper" })
public class IdocPrepositionApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdocPrepositionApplication.class, args);
    }

}
