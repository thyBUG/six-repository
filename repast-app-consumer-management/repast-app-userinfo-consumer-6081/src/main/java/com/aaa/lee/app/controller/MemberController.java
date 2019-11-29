package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.History;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: repast-app-parent
 * @Package: com.aaa.six.app.controller
 * @ClassName: MemberController
 * @Author: Administrator
 * @Date: 2019/11/21 0021 16:35
 * @Version: 1.0
 */
@RestController
@Api(value = "用户信息",tags = "用户信息接口")
public class MemberController extends BaseController {

    @Autowired
    private IRepastService repastService;

    /**
     * 登录
     * @param member
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "登录",notes = "执行登陆操作")
    public ResultData doLogin(Member member){
        if (repastService.doLogin(member)){
            return success();
        }else {
            return failed();
        }
    }

    /**
     * 接收用户信息
     * @param member
     * @return
     */
    @PostMapping("/userMessage")
    @ApiOperation(value = "微信",notes = "接收微信认证的信息")
    public ResultData getMessage(Member member){
        if(repastService.newUser(member)){
            return success("存储成功");
        }else {
            return failed("储存失败");
        }

    }



    /**
     * 查询余额
     */
    @PostMapping("/selectBalance")
    @ApiOperation(value = "查询余额",notes = "查询用户余额")
    public ResultData selectBalance(){
        Double balance = repastService.selectBalance();
        if (null != balance){
            return success(balance);
        }else {
            return failed();
        }
    }

    /**
     * 余额充值之后的余额变动
     * @param number
     * @return
     */
    @PostMapping("/updateBalance")
    @ApiOperation(value = "修改余额",notes = "充值后的余额变动")
    public ResultData updateBalance(Double number){
        Integer i = repastService.updateBalance(number);
        if (null != i){
            return success("修改成功",i);
        }else {
            return failed("修改异常");
        }

    }
    @PostMapping("/selectAllProduct")
    @ApiOperation(value = "查询积分商城", notes = "查询积分商城所有商品")
    public ResultData selectAll(){
        List<Product> products = repastService.selectAll();
        if (null!=products){
            return success(products);
        }else {

            return failed();
        }

    }
    /**
     * integration
     * 查询会员总积分
     */
    @PostMapping("selectById")
    public Integer selectById(){

        Integer integer = repastService.selectById();
        if (null!=integer){
            return integer;
        }
        return 0;
    }


    /**
     * 通过会员id
     * 查询积分明细
     */
    @PostMapping("/selectId")
    public ResultData selectId(){

        List<History> histories = repastService.selectId();
        if (null!= histories){
            return success(histories);
        }
        return null;
    }
}
