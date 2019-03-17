package com.tongfu.idoccloud.preposition.feign.system;

import com.tongfu.idoccloud.preposition.entity.User;
import com.tongfu.idoccloud.preposition.feign.system.fallback.SystemFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/3/12 16:36
 */
@FeignClient(name = "system-service",fallback = SystemFeignFallback.class)
public interface SystemFeign {

    @PostMapping(value = "/api/user/v1/login",consumes = "application/json")
    public User login(@RequestBody User  user,@RequestParam("db_name") String db_name);

    @PostMapping(value = "/api/user/v1/checkPassword",consumes = "application/json")
    public Object checkPassword(@RequestBody User  user, @RequestParam("db_name") String db_name);
}

