package com.tongfu.idoccloud.preposition.feign.system;

import com.tongfu.idoccloud.preposition.entity.User;
import com.tongfu.idoccloud.preposition.feign.system.fallback.UserFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/3/12 16:36
 */
@FeignClient(name = "system-service",fallback = UserFeignFallback.class)
public interface UserFeign {

    @PostMapping(value = "/api/user/v1/login",consumes = "application/json")
    public Object login(@RequestParam("userCode") String  userCode,
                      @RequestParam("password") String  password,
                        @RequestParam("ip") String  ip,
                        @RequestParam("deviceNumber") String  deviceNumber,
                      @RequestParam("db_name") String db_name);

    @PostMapping(value = "/api/user/v1/checkPassword")
    public Object checkPassword(@RequestParam("userCode") String  userCode,
                                @RequestParam("password") String password,
                                @RequestParam("idoc_token") String idoc_token);

    @PostMapping(value = "/api/user/v1/changeInitPass")
    public Object changeInitPass(@RequestParam("userCode") String  userCode,
                                @RequestParam("password") String password,
                                @RequestParam("idoc_token") String idoc_token);


}

