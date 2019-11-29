package com.aaa.lee.app.controller;

import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.service.MemberService;
import com.aaa.lee.app.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: repast-app-parent
 * @Package: com.aaa.lee.app.controller
 * @ClassName: MemberController
 * @Author: Administrator
 * @Date: 2019/11/21 0021 20:26
 * @Version: 1.0
 */
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private RedisService redisService;

    /**
     * 执行登录
     * @param member
     * @return
     */
    @PostMapping("/login")
    public Boolean doLogin(@RequestBody Member member) throws Exception {
        return memberService.doLogin(member,redisService);
    }

    @PostMapping("/userMessage")
    public  Boolean newUser(@RequestBody Member member)throws Exception{
    return memberService.newUser(member,redisService);
    }

    /**
     * 查询余额
     * @return
     */
    @PostMapping("/selectBalance")
    public Double selectBalance()throws Exception{
        return memberService.selectBalance(redisService);
    }

    @PostMapping("/updateBalance")
    public Integer updateBalance(@RequestParam("number") Double number)throws Exception{
        return memberService.updateBalance(number,redisService);
    }
    /**
     * 查询总积分
     */
    @PostMapping("/selectById")
    public Integer selectById(){

        return   memberService.selectById(redisService);
    };
}
