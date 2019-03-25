package com.tongfu.idoccloud.zuul;

import com.tongfu.idoccloud.zuul.filter.CorsControllerFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableZuulProxy
public class IdocZuulApplication {

//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        CorsControllerFilter corsControllerFilter = new CorsControllerFilter();
//        registrationBean.setFilter(corsControllerFilter);
//        return registrationBean;
//
//    }


    public static void main(String[] args) {
        SpringApplication.run(IdocZuulApplication.class, args);
    }

}
