package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.MyOrder;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @param
 * @ClassName MyCollects
 * @Author li
 * @Date 2019/11/29
 * @Version 1.0
 **/
@RestController
@Api(value = "我的收藏", tags = "展示我的收藏页面信息")
public class MyCollectsController extends BaseController {

    @Autowired
    private IRepastService repastService;

    /**
     * 点击商品添加收藏
     * @param shopId
     * @return
     */
    @PostMapping("/pCollect")
    @ApiOperation(value = "商品收藏", notes = "浏览商品信息时点击收藏")
    public ResultData productCollects(Long shopId) {
        Boolean a = repastService.productCollects(shopId);
        if(a == true){
            return success();
        }else {
            return failed();
        }
    }

    /**
     * 添加订单的收藏
     * @param orderId
     * @return
     */
    @PostMapping("/oCollect")
    @ApiOperation(value = "订单商品收藏", notes = "下订单时点击收藏")
    public ResultData orderCollects(Long orderId) {
        Boolean a = repastService.orderCollects(orderId);

        if(a == true){
            return success();
        }else {
            return failed();
        }
    }

    /**
     * 获取商品收藏列表
     * @return
     */
    @GetMapping("/getAllCollect")
    @ApiOperation(value = "商品收藏列表", notes = "获取所有收藏商品列表")
    public ResultData getAllCollects() {
        List<Product> a = repastService.getAllCollects();
        if(a.size()>0){
            return success(a);
        }else {
            return failed();
        }
    }

    /**
     * 获取收藏订单列表
     * @return
     */
    @GetMapping("/getOrders")
    @ApiOperation(value = "获取订单信息",notes = "获取所有收藏订单信息")
    public ResultData GetAllOrders(){
        List<MyOrder> myOrders = repastService.GetAllOrders();
        if(myOrders != null){
            return success(myOrders);
        }else{
            return failed();
        }
    }





}
