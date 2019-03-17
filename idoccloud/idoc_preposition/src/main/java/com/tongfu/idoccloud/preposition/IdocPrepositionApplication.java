package com.tongfu.idoccloud.preposition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //服务间的通讯 feign （ribbon）
//@EnableCircuitBreaker //熔断降级（断路器） hystrix用到
//@EnableHystrixDashboard//断路器 仪表
public class IdocPrepositionApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdocPrepositionApplication.class, args);
    }

}
