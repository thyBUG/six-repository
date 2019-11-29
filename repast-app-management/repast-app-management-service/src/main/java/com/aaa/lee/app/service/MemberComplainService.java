package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.MemberComplain;
import com.aaa.lee.app.mapper.MemberComplainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

@Service
public class MemberComplainService extends BaseService<MemberComplain> {
    @Autowired
    private MemberComplainMapper memberComplainMapper;
    @Override
    public Mapper<MemberComplain> getMapper() {
        return memberComplainMapper;
    }

    /**
     * 新增意见反馈
     * @param memberComplain
     * @return
     */
    public int addMemberComplain(MemberComplain memberComplain)  {
      int i = memberComplainMapper.insert(memberComplain);
      return i;
  }
}
