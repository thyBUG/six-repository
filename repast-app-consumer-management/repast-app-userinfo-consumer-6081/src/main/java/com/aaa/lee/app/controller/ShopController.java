package com.aaa.lee.app.controller;
import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(value = "店铺信息接口",tags = "店铺信息详细接口")
public class ShopController extends BaseController {
    @Autowired
    private IRepastService iRepastService;

    @ApiOperation(value = "评论",notes = "执行评论操作")
    @GetMapping("/shop")
    public  ResultData shopResult(Integer id,String token){
        ResultData resultData = iRepastService.shopResult(id, token);
        return resultData;

    }

}
