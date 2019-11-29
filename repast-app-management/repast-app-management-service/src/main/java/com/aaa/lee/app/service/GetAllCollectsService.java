package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.mapper.ProductMapper;
import com.aaa.lee.app.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import static com.aaa.lee.app.staticstatus.StaticProperties.REDIS_KEY;

/**
 * @param
 * @ClassName GetAllCollectsService
 * @Author li
 * @Date 2019/11/24
 * @Version 1.0
 **/
@Service
public class GetAllCollectsService extends BaseService<Product> {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Mapper<Product> getMapper() {
        return productMapper;
    }

    /**
     *获取收藏列表的操作
     * @param
     * @return
     */
    public List<Product> GetAllCollects(RedisService redisService){
        String key = redisService.get(REDIS_KEY);
        Member member = JSONUtil.toObject(key, Member.class);

        if(member != null){
            List<Product> collects = productMapper.getAllCollects(member.getId());
            return collects;
        }else {
            return null;
        }

    }

}
