package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.domain.MyOrder;
import com.aaa.lee.app.mapper.MemberMapper;
import com.aaa.lee.app.mapper.MyOrderMapper;
import com.aaa.lee.app.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import static com.aaa.lee.app.staticstatus.StaticProperties.REDIS_KEY;

/**
 * @param
 * @ClassName GetAllOrdersService
 * @Author li
 * @Date 2019/11/27
 * @Version 1.0
 **/
@Service
public class GetAllOrdersService extends BaseService<MyOrder> {

    @Autowired
    private MyOrderMapper myOrderMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Mapper<MyOrder> getMapper() {
        return null;
    }

    /**
     * 获取订单信息列表信息
     * @param token
     * @return
     */
    public List<MyOrder> getAllOrders(String token){

        Member member = memberMapper.selectByTokenId(token);

        if(member != null){
            List<MyOrder> myOrders = myOrderMapper.getAllOrders(member.getId());
            return myOrders;
        }else {
            return null;
        }

    }
}
