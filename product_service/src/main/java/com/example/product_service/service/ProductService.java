package com.example.product_service.service;

import com.example.product_service.domain.Product;

import java.util.List;

/**
 * @Author: Sijie Zhi
 * @Date: 2018/12/21 15:29
 */
public interface ProductService {
    List<Product> listProduct();

    Product findById(int id);
}
