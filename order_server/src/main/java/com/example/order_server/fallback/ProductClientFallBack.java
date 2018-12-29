package com.example.order_server.fallback;

import com.example.order_server.service.ProductClient;
import org.springframework.stereotype.Component;

/**
 * @Author: Sijie Zhi
 * @Date: 2018/12/26 11:05
 */
@Component
public class ProductClientFallBack implements ProductClient {

    @Override
    public String findById(int id) {
        System.out.println("商品服务接口请求异常》》》》》》");
        return null;
    }
}
