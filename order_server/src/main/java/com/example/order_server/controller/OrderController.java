package com.example.order_server.controller;

import com.example.order_server.service.ProductOrderService;
import com.example.order_server.utils.RedisClient;
import com.example.order_server.utils.ResultData;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Sijie Zhi
 * @Date: 2018/12/24 9:57
 */
@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private ProductOrderService productOrderService;

    @Resource
    private RedisClient redisClient;

    @RequestMapping("save")
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Object save(@RequestParam("user_id") int userId, @RequestParam("product_id") int productId, HttpServletRequest request) {

        return new ResultData(200, "服务间通讯成功", productOrderService.save(userId, productId));
    }

    //方法名 必须一致
    public Object saveOrderFail(int userId, int productId, HttpServletRequest request) {
        final String redisKey = "order:save-order";
        String keyValue = redisClient.get(redisKey);

        //模拟发现短信通知
        new Thread(() -> {
            if (StringUtils.isEmpty(keyValue)) {
                String ip = request.getRemoteAddr();
                StringBuffer url = request.getRequestURL();
                String uri = request.getRequestURI();
                System.out.println("短信提示：order:save-order服务出现问题，请及时修复！ip》 " + ip + " url>" + url + " uri>" + uri);
                redisClient.set(redisKey, "order:save-order服务出现问题，请及时修复！", 20);
            } else {
                System.out.println("短信已发送，20秒后再次发送");
            }
        }).start();


        return new ResultData(400, "对不起，商品访问人数过多，请稍后再试");
    }
}
