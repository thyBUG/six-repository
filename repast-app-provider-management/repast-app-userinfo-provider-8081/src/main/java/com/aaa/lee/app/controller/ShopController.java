package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Shop;
import com.aaa.lee.app.service.CommentService;
import com.aaa.lee.app.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ShopController extends BaseController {


    @Autowired
    private ShopService shopService;
    @Autowired
    private CommentService commentService;


    /***
     * 根据订单ID查店铺信息
     * @param id
     * @return
     */
    @GetMapping("/shop")
    public ResultData shopResult(@RequestParam("shopId") Integer id,@RequestParam("token") String token){
        Shop shop = shopService.shopAll(id,token,commentService);
        if (null!=shop){
           return success("查询成功",shop);
        }else {
            return failed("查询失败");
        }
    }

}
