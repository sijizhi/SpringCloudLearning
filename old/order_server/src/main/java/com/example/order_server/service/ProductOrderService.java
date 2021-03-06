package com.example.order_server.service;


import com.example.order_server.domain.ProductOrder;

/**
 * 订单业务类
 */
public interface ProductOrderService {
    /**
     * 下单接口
     *
     * @param userId
     * @param productId
     * @return
     */
    ProductOrder save(int userId, int productId);


}
