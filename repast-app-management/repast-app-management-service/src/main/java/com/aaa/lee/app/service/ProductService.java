package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class ProductService extends BaseService {


    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductMapper getMapper() {

        return productMapper;
    }

    /***
     * 积分商城
     * 获取所有可兑换的商品信息
     * @return
     */
   public List<Product> selectAll(){
       List<Product> products = productMapper.selectAll();
       if (null!=products){
           return products;
       }
        return null;

   }


}
