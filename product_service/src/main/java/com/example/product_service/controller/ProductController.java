package com.example.product_service.controller;

import com.example.product_service.domain.Product;
import com.example.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Sijie Zhi
 * @Date: 2018/12/21 15:18
 */
@RestController
@RequestMapping("/api/vi/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 商品列表
     * @return
     */
    @RequestMapping("/list")
    public List<Product> list(){
        return productService.listProduct();
    }

    /**
     * 单个商品
     * @param id
     * @return
     */
    @RequestMapping("/findid")
    public Product findid(@RequestParam("id") int id){
        return productService.findById(id);
    }


}
