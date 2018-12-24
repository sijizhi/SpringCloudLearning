package com.example.product_service.controller;

import com.example.product_service.domain.Product;
import com.example.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Sijie Zhi
 * @Date: 2018/12/21 15:18
 */
@RestController
@RequestMapping("/api/vi/product")
@PropertySource({"classpath:application.yml"})
public class ProductController {

    @Autowired
    private ProductService productService;

    @Value("${server.port}")
    private String port;

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

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("调用的端口号是：>>>>> "+port);
        Product product=productService.findById(id);
        product.setPort(port);
        return product;
    }


}
