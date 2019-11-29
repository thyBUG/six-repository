package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.domain.PmsCollect;
import com.aaa.lee.app.mapper.PmsCollectMapper;
import com.aaa.lee.app.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import static com.aaa.lee.app.staticstatus.StaticProperties.REDIS_KEY;

/**
 * @param
 * @ClassName DoProductCollectService
 * @Author li
 * @Date 2019/11/23
 * @Version 1.0
 **/
@Service
public class DoProductCollectService extends BaseService<PmsCollect> {

    @Autowired
    private PmsCollectMapper pmsCollectMapper;
    PmsCollect collect = new PmsCollect();

    @Override
    public Mapper<PmsCollect> getMapper() {
        return pmsCollectMapper;
    }

    /**
     * 购买商品执行添加收藏信息
     * @param shopId
     * @param
     * @param redisService
     * @return
     */
    public Boolean DoProductCollect(Long shopId, RedisService redisService){
        String s = redisService.get(REDIS_KEY);
        Member member = JSONUtil.toObject(s, Member.class);

        if(member != null){
            Long memberId = member.getId();
            collect.setMemberId(memberId);
            collect.setProductId(shopId);
            int i = pmsCollectMapper.insert(collect);
            if(i>0){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
