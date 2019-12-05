package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.Product;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Administrator
 */
public interface ProductMapper extends Mapper<Product> {

    /**
     * 订单信息
     * @param shopId
     * @return
     */
    List<Product> getProductByShopId(Long shopId);

    /**
     * 获取商品收藏列表信息
     * @param
     * @return
     */
    List<Product> getAllCollects(Long id);


    List<Product> selectAll();

}