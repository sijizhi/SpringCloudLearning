package com.example.order_server.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 商品服务客户端
 * @Author: Sijie Zhi
 * @Date: 2018/12/24 14:09
 */
@FeignClient(name = "product-server")
public interface ProductClient {
    @GetMapping("/api/vi/product/findid")
    String findById(@RequestParam(value = "id") int id);
}
