package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.domain.CouponInfo;
import com.aaa.lee.app.service.IRepastService;
import com.aaa.lee.app.vo.MemberCouponInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "优惠券接口",tags = "调用优惠券接口")
public class CouponController extends BaseController {

    @Autowired
    private IRepastService repastService;

    /**
     * 通过member_id获取所有的优惠券
     */
    @PostMapping("/allCoupon")
    @ApiOperation(value = "查询", notes = "执行查询优惠券操作")
    public List<MemberCouponInfoVo> allMemberCouponInfo(Long memberId) {
        List<MemberCouponInfoVo> couponResult = repastService.allMemberCouponInfo(memberId);
        if (couponResult != null) {
            //说明查询到消息
            return couponResult;
        }
        return null;
    }

    /**
     * 查询所有未使用的优惠券
     * @param memberId
     * @return
     */
    @PostMapping("/UnusedCoupon")
    @ApiOperation(value = "查询", notes = "执行查询未使用优惠券操作")
    public List<MemberCouponInfoVo> UnusedMemberCouponInfo(Long memberId) {
        List<MemberCouponInfoVo> unusedCoupon = repastService.UnusedMemberCouponInfo(memberId);
        if (unusedCoupon != null) {
            //说明查询到消息
            return unusedCoupon;
        }
        return null;
    }

    /**
     * 查询所有已使用的优惠券
     * @param memberId
     * @return
     */
    @PostMapping("/usedCoupon")
    @ApiOperation(value = "查询", notes = "执行查询已使用优惠券操作")
    public List<MemberCouponInfoVo> usedMemberCouponInfo(Long memberId) {
        List<MemberCouponInfoVo> unusedCoupon = repastService.UnusedMemberCouponInfo(memberId);

        if (unusedCoupon != null) {
            //说明查询到消息
            return unusedCoupon;
        }
        return null;
    }


    /**
     *
     * 领券中心
     *
     */

        @PostMapping("/getCoupon")
        @ApiOperation(value = "查询", notes = "执行查询领券中心数据")
        public List<CouponInfo> getCouponCenter(){
            List<CouponInfo> couponCenter = repastService.getCouponCenter();
            if(couponCenter != null){
                return couponCenter;
            }
            return null;

        }



}
