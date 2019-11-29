package com.aaa.lee.app.controller;


import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 查询商品信息
 * @author Administrator
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;



    /**
     * 积分商城，查询所有可兑换的商品信息
     * @return
     */
    @PostMapping("/selectAll")
    public List<Product> selectAll(){
     return   productService.selectAll();
    };



}
