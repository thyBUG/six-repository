package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.CouponInfo;
import com.aaa.lee.app.mapper.CouponInfoMapper;
import com.aaa.lee.app.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Service
public class GetCouponCenterService extends BaseService<CouponInfo> {

    @Autowired
    private CouponInfoMapper couponInfoMapper;

    @Override
    public Mapper<CouponInfo> getMapper() {
        return couponInfoMapper;
    }
    /**
     * 查询领券中心数据
     * @return
     */
    public List<CouponInfo> allGetCoupon(RedisService redisService){
        List<CouponInfo> couponCenter = couponInfoMapper.getCouponCenter();
        if(couponCenter != null){
            //说明领券中心不为空
            //将查询到的信息存入redis中
            String couponString = JSONUtil.toJsonString(couponCenter);
            String setResult = redisService.set("token",couponString);
            if(setResult != null){
                return couponCenter;
            }

        }
        return null;
    }

}
