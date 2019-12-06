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
    public Boolean productCollects(@RequestParam(value = "shopId") Long shopId,@RequestParam(value = "token") String token){

        return doProductCollectService.DoProductCollect(shopId,token);
    };

    /**
     * 下订单执行收藏操作
     * @param orderId
     * @param
     * @return
     */
    @PostMapping("/oCollect")
    public Boolean orderCollects(@RequestParam(value = "orderId") Long orderId,@RequestParam(value = "token") String token){
        return doOrderCollectService.orderCollectss(orderId,token);
    };

    /**
     * 执行获取所有收藏信息操作
     * @param
     * @return
     */
    @GetMapping("/getAllCollect")
    public List<Product> getAllCollects(@RequestParam(value = "token") String token){
        return getAllCollects.GetAllCollects(token);
    };

    /**
     * 获取所有订单信息信息
     * @return
     */
    @GetMapping("/getAllOrder")
    public List<MyOrder> GetAllOrders(@RequestParam(value = "token") String token){
        return getAllOrdersService.getAllOrders(token);
    };


}
