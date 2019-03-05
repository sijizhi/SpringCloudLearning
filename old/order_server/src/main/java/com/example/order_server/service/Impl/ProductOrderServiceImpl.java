package com.example.order_server.service.Impl;

import com.example.order_server.domain.ProductOrder;
import com.example.order_server.service.ProductClient;
import com.example.order_server.service.ProductOrderService;
import com.example.order_server.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: Sijie Zhi
 * @Date: 2018/12/24 9:40
 */
@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    //    @Autowired
//    private RestTemplate restTemplate;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private ProductClient productClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Override
    public ProductOrder save(int userId, int productId) {

//        Object obj = restTemplate.getForObject("http://product-server/api/vi/product/findid?id="+productId, Object.class);
//        System.out.println(obj);
//        ServiceInstance serviceInstance=loadBalancerClient.choose("product-server");
//        System.out.println("端口号：》》"+serviceInstance.getPort());
//        RestTemplate restTemplate=new RestTemplate();
//        //制作url
//        String url= String.format("http://%s:%s/api/vi/product/findid?id="+productId, serviceInstance.getHost(),serviceInstance.getPort());
//        Map<String,Object> map=restTemplate.getForObject(url, Map.class );

        if (userId == 1 || userId == 3) {
            return null;
        }

        logger.info("order-server save");
        String jsonResult = productClient.findById(productId);
        Map<String, Object> map = JsonUtils.string2Obj(jsonResult, Map.class);
        System.out.println("productClient:>>>" + map.get("port"));
        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());
        productOrder.setPrice(Integer.parseInt(map.get("price").toString()));
        productOrder.setProductName(map.get("name").toString());
        productOrder.setPort(map.get("port").toString());
        productOrder.setDev(map.get("dev").toString());
        System.out.println("productOrder》》》》" + productOrder);
        return productOrder;
    }
}
