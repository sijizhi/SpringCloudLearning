package com.example.order_server.service;

import com.example.order_server.fallback.ProductClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 商品服务客户端
 * @Author: Sijie Zhi
 * @Date: 2018/12/24 14:09
 */
@FeignClient(name = "product-server",fallback = ProductClientFallBack.class)
public interface ProductClient {
    @GetMapping("/api/v1/product/findid")
    String findById(@RequestParam(value = "id") int id);
}
