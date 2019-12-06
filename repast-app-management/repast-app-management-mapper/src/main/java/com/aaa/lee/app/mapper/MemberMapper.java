package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.domain.UpdateBalance;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

public interface MemberMapper extends Mapper<Member> {
    int updateBalance(UpdateBalance ub);
    int updateBir(Map<String,Object> map );


    Member selectByTokenId(String token);
}