package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.MemberCouponInfo;
import com.aaa.lee.app.mapper.MemberCouponInfoMapper;
import com.aaa.lee.app.utils.JSONUtil;
import com.aaa.lee.app.vo.MemberCouponInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static com.aaa.lee.app.staticstatus.StaticProperties.*;

@Service
public class AllMemberCouponService extends BaseService<MemberCouponInfo> {
    @Autowired
    private MemberCouponInfoMapper memberCouponInfoMapper;

    @Override
    public Mapper<MemberCouponInfo> getMapper() {
        return memberCouponInfoMapper;
    }

    /**
     * 查询所有优惠券信息
     *
     * @param memberId
     * @param redisService
     * @return
     */
    public List<MemberCouponInfoVo> allMemberCouponInfo(Long memberId, RedisService redisService) {
        try {
            List<MemberCouponInfoVo> allMemberCouponInfo = memberCouponInfoMapper.getAllMemberCouponInfo(memberId);
                //获取当前时间
                SimpleDateFormat currentTime1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String currentTime = currentTime1.format(new Date());
           HashMap<String, String> statusMap = new HashMap<String, String>();

            if (null != allMemberCouponInfo) {//说明查询到所有优惠券
                for (MemberCouponInfoVo coupon:allMemberCouponInfo) {
                   //获取到数据库中的优惠券开始时间和结束时间，并将数据格式化
                    Date startTime = coupon.getStartTime();
                    String newStartTime = currentTime1.format(startTime);

                    Date endTime = coupon.getEndTime();
                    String newEndTime = currentTime1.format(endTime);

                    //判断该优惠券是否过期
                    if(currentTime.compareTo(newStartTime)<0){
                        //说明当前时间小于开始时间，提示用户不可用信息
                        statusMap.put("1", COUPON_NOT_AVAILABLE);
                    }else if(currentTime.compareTo(newStartTime)>0 && currentTime.compareTo(newEndTime)<0){
                        statusMap.put("2",COUPON_IS_AVAILABLE);
                    }else {
                        //说明该优惠券可用
                        statusMap.put("3", COUPON_HAS_EXPIRED);
                    }

                }


                //将查询到的信息存入redis中
                String couponString = JSONUtil.toJsonString(allMemberCouponInfo);
                String setResult = redisService.set("allMemberCouponInfo.couponId", couponString);
                if (OK.equals(setResult)) {
                    //说明存入成功
                    return allMemberCouponInfo;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询所有未使用优惠券的信息
     * @param memberId
     * @param redisService
     * @return
     */
    public List<MemberCouponInfoVo> UnusedMemberCouponInfo(Long memberId, RedisService redisService) {
        try {
            List<MemberCouponInfoVo> unusedMemberCoupon = memberCouponInfoMapper.getUnusedMemberCouponInfo(memberId);
            if (unusedMemberCoupon != null) {
                //说明查询到所有优惠券
                //将查询到的信息存入redis中
                String unuseCcouponString = JSONUtil.toJsonString(unusedMemberCoupon);
                String setResult = redisService.set("allMemberCouponInfo.couponId", unuseCcouponString);
                if (OK.equals(setResult)) {
                    //说明存入成功
                    return unusedMemberCoupon;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }



    /**
     * 查询所有已使用优惠券的信息
     * @param memberId
     * @param redisService
     * @return
     */
    public List<MemberCouponInfoVo> usedMemberCouponInfo(Long memberId, RedisService redisService) {
        try {
            List<MemberCouponInfoVo> usedMemberCoupon = memberCouponInfoMapper.getUsedMemberCouponInfo(memberId);
            if (usedMemberCoupon != null) {
                //说明查询到所有优惠券
                //将查询到的信息存入redis中
                String usedCouponString = JSONUtil.toJsonString(usedMemberCoupon);
                String setResult = redisService.set("couponId", usedCouponString);
                if (OK.equals(setResult)) {
                    //说明存入成功
                    return usedMemberCoupon;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }









}