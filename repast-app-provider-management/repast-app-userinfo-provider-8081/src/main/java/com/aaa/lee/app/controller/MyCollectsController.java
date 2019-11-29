package com.aaa.lee.app.controller;

import com.aaa.lee.app.domain.MyOrder;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @param
 * @ClassName MyCollectsController
 * @Author li
 * @Date 2019/11/29
 * @Version 1.0
 **/
@RestController
public class MyCollectsController {

    @Autowired
    private DoProductCollectService doProductCollectService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private DoOrderCollectService doOrderCollectService;

    @Autowired
    private GetAllCollectsService getAllCollects;

    @Autowired
    private GetAllOrdersService getAllOrdersService;

    /**
     * 购买商品执行添加收藏信息
     * @param shopId
     * @param
     * @return
     */
    @PostMapping("/pCollect")
    public Boolean productCollects(@RequestParam(value = "shopId") Long shopId){

        return doProductCollectService.DoProductCollect(shopId,redisService);
    };

    /**
     * 下订单执行收藏操作
     * @param orderId
     * @param
     * @return
     */
    @PostMapping("/oCollect")
    public Boolean orderCollects(@RequestParam(value = "orderId") Long orderId){
        return doOrderCollectService.orderCollectss(orderId, redisService);
    };

    /**
     * 执行获取所有收藏信息操作
     * @param
     * @return
     */
    @GetMapping("/getAllCollect")
    public List<Product> getAllCollects(){
        return getAllCollects.GetAllCollects(redisService);
    };

    /**
     * 获取所有订单信息信息
     * @return
     */
    @GetMapping("/getAllOrder")
    public List<MyOrder> GetAllOrders(){
        return getAllOrdersService.getAllOrders(redisService);
    };


}
