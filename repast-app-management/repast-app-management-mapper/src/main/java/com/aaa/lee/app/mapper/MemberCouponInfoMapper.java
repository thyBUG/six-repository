package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.MemberCouponInfo;
import com.aaa.lee.app.vo.MemberCouponInfoVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface MemberCouponInfoMapper extends Mapper<MemberCouponInfo> {
    /**
     * 查询所有优惠券的信息
     * @param MemberId
     * @return
     */
    List<MemberCouponInfoVo> getAllMemberCouponInfo(Long MemberId);

    /**
     * 查询所有未使用的优惠券信息
     */
    List<MemberCouponInfoVo> getUnusedMemberCouponInfo(Long MemberId);

    /**
     * 查询所有已使用的优惠券信息
     */
    List<MemberCouponInfoVo> getUsedMemberCouponInfo(Long MemberId);

    /**
     * 添加会员优惠券
     * @param memberCouponInfo
     * @return
     */
    Boolean addCouponToMember(MemberCouponInfo memberCouponInfo);

    /**
     * 查询优惠券的数量

     * @param couponId
     * @return
     */
    Long countOfCoupon(Long memberId, Long couponId);
}