package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.History;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.mapper.HistoryMapper;
import com.aaa.lee.app.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import static com.aaa.lee.app.staticstatus.StaticProperties.*;

/***
 * 查询积分明细
 * @author Administrator
 */

@Service
public class HistoryService extends BaseService<History> {


    @Autowired
    private HistoryMapper historyMapper;
    @Override
    public Mapper<History> getMapper() {

        return historyMapper;
    }

    public List<History>  selectId(RedisService redisService){
        String user = redisService.get(REDIS_KEY);
        Member member = JSONUtil.toObject(user, Member.class);
        Long id = member.getId();
        List<History> histories = historyMapper.selectMemberId(id);
        System.out.println(histories);
        if (null!=histories){
            return histories;
        }
        return null;

    }



}
