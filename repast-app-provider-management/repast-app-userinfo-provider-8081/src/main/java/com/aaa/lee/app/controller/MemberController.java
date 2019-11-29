package com.aaa.lee.app.controller;

import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.domain.MemberComplain;
import com.aaa.lee.app.service.MemberComplainService;
import com.aaa.lee.app.service.MemberService;
import com.aaa.lee.app.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
    @Autowired
    private MemberComplainService memberComplainService;


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
    /**
     * @param [member]
     * @return java.lang.Boolean
     * @throws
     * @author Seven Lee
     * @description 修改会员生日
     * @date 2019/11/21
     **/

    @PostMapping("/updateBirth")
    public Boolean updateBirthday(@RequestParam("birthday") Date birthday, @RequestParam("id") Long id ) {
        int i = memberService.updateBirthday(birthday,id);
        if (i > 0) {
            return true;

        } else {
            return false;
        }
    }

    /**
     * 新增意见反馈
     * @param memberComplain
     * @return
     */

    @PostMapping("/addcomplain")
    public Boolean addMemberComplain(@RequestBody MemberComplain memberComplain ){
        int i = memberComplainService.addMemberComplain(memberComplain);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
}
