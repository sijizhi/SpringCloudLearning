package com.example.order_server.service.Impl;

import com.example.order_server.domain.ProductOrder;
import com.example.order_server.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: Sijie Zhi
 * @Date: 2018/12/24 9:40
 */
@Service
public class ProductOrderServiceImpl  implements ProductOrderService {
//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Override
    public ProductOrder save(int userId, int productId) {
//        Object obj = restTemplate.getForObject("http://product-server/api/vi/product/findid?id="+productId, Object.class);

//        System.out.println(obj);

        ServiceInstance serviceInstance=loadBalancerClient.choose("product-server");
        System.out.println("端口号：》》"+serviceInstance.getPort());
        RestTemplate restTemplate=new RestTemplate();
        //制作url
        String url= String.format("http://%s:%s/api/vi/product/findid?id="+productId, serviceInstance.getHost(),serviceInstance.getPort());
        Map<String,Object> map=restTemplate.getForObject(url, Map.class );
        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());
        productOrder.setPrice(Integer.parseInt(map.get("price").toString()));
        productOrder.setProductName(map.get("name").toString());
        return productOrder;
    }
}
