package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.MyOrder;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MyOrderMapper extends Mapper<MyOrder> {

    /**
     * 获取订单信息列表
     * @param memberid
     * @return
     */
    List<MyOrder> getAllOrders(Long memberid);
}