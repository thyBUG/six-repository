package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.CouponInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CouponInfoMapper extends Mapper<CouponInfo> {
    List<CouponInfo> getCouponCenter();
    CouponInfo getCouponById(Long couponId);

}