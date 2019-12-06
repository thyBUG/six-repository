package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.domain.PmsCollect;
import com.aaa.lee.app.mapper.MemberMapper;
import com.aaa.lee.app.mapper.PmsCollectMapper;
import com.aaa.lee.app.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import static com.aaa.lee.app.staticstatus.StaticProperties.REDIS_KEY;

/**
 * @param
 * @ClassName DoOrderCollectService
 * @Author li
 * @Date 2019/11/23
 * @Version 1.0
 **/
@Service
public class DoOrderCollectService extends BaseService<PmsCollect> {

    @Autowired
    private PmsCollectMapper pmsCollectMapper;

    @Autowired
    private MemberMapper memberMapper;

    PmsCollect collect = new PmsCollect();

    @Override
    public Mapper<PmsCollect> getMapper() {
        return pmsCollectMapper;
    }

    /**
     * 下订单执行收藏操作
     * @param orderId
     * @param
     * @param token
     * @return
     */
    public Boolean orderCollectss(Long orderId, String token){

        Member member = memberMapper.selectByTokenId(token);
        Long mId = member.getId();

        if(member != null){
            collect.setOrderId(orderId);
            collect.setMemberId(mId);
            collect.setToken(token);
            int i = pmsCollectMapper.insert(collect);
            if(i>0){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

}
