package com.aaa.lee.app.service;

import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.fallback.RepastFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/20 11:40
 * @Description
 *      当使用feign进行传参的时候，如果是对象,包装类型,实体类...必须要使用@RequestBody，并且这个@RequestBody只能在该方法中出现一次
 *          ResultData selectUsersCondition(@RequestBody User user, @RequestBody UserInfo userInfo);---->错误
 *      当传递的参数是简单类型(String, Integer....8种基本类型+String)，必须要使用@RequestParam("")，这个@RequestPara注解可以出现多个
 *          ResultData selectUsersCondition(@RquestPara("username") String username, @RequestParam("age") Integer age);---->正确
 *
 **/
@FeignClient(value = "userinfo-interface-provider", fallbackFactory = RepastFallBackFactory.class)
public interface IRepastService {
    /**
     * 执行登录
     * @param member
     * @return
     */
    @PostMapping("/login")
    Boolean doLogin(@RequestBody Member member);

    /**
     * 接收用户信息
     * @param member
     * @return
     */
    @PostMapping("/userMessage")
    Boolean newUser(@RequestBody Member member);

    /**
     * 执行查询余额
     * @return
     */
   @PostMapping("/selectBalance")
    Double selectBalance();

    /**
     * 充值后改变余额
     */
   @PostMapping("/updateBalance")
    Integer updateBalance(@RequestParam("number") Double number);

}
