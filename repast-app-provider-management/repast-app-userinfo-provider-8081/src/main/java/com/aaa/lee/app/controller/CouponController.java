package com.aaa.lee.app.controller;

import com.aaa.lee.app.domain.CouponInfo;
import com.aaa.lee.app.service.AllMemberCouponService;
import com.aaa.lee.app.service.GetCouponCenterService;
import com.aaa.lee.app.service.RedisService;
import com.aaa.lee.app.vo.MemberCouponInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CouponController {
    @Autowired
    private AllMemberCouponService allMemberCouponService;
    @Autowired
    private RedisService redisService;

    @Autowired
    private GetCouponCenterService getCouponCenterService;


    /**
     * 查询所有优惠券
     * @param memberId
     * @return
     */
    @PostMapping("/allCoupon")
    public List<MemberCouponInfoVo> allMemberCouponInfo(@RequestParam("memberId") Long memberId){
        return allMemberCouponService.allMemberCouponInfo(memberId,redisService);
    }

    /**
     * 查询所有未使用优惠券
     */
    @PostMapping("/allUnusedCoupon")
    public List<MemberCouponInfoVo> UnusedMemberCouponInfo(@RequestParam("memberId") Long memberId){
        return allMemberCouponService.UnusedMemberCouponInfo(memberId,redisService);
    }


    /**
     * 查询所有已使用优惠券
     * @param memberId
     * @return
     */

    @PostMapping("/allUsedCoupon")
   public List<MemberCouponInfoVo> usedMemberCouponInfo(@RequestParam("memberId") Long memberId){
        return allMemberCouponService.usedMemberCouponInfo(memberId,redisService);
    }

    /**
     * 查询优惠券中心
     * @return
     */
    @PostMapping("/getCoupon")
    public List<CouponInfo> getCouponCenter(){
        return getCouponCenterService.allGetCoupon(redisService);
    }


}
