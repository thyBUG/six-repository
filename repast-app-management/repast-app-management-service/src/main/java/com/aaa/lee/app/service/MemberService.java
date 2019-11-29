package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.domain.UpdateBalance;
import com.aaa.lee.app.mapper.MemberMapper;
import com.aaa.lee.app.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.aaa.lee.app.staticstatus.StaticProperties.*;


/**
 * @ProjectName: repast-app-parent
 * @Package: com.aaa.lee.app.service
 * @ClassName: MemberService
 * @Author: Administrator
 * @Date: 2019/11/21 0021 20:32
 * @Version: 1.0
 */
@Service
public class MemberService extends BaseService<Member> {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Mapper<Member> getMapper() {
        return memberMapper;
    }

    /**
     * 执行登录操作
     * @param member
     * @param redisService
     * @return
     */
    public Boolean doLogin(Member member,RedisService redisService){
        try {
            Member member1 = super.selectOne(member);
            if (null != member1){
               //数据库中有数据，登录成功
                //将用户存入redis中
                member1.setPassword(null);
                String memberString = JSONUtil.toJsonString(member1);
                //此处存的REDIS_KEY应为member.getToken
                String setResult = redisService.set(REDIS_KEY, memberString);
                if (OK.equals(setResult.toUpperCase())){
                    //redis存入成功
                    return true;
                }
            }else {
                //数据库中无数据
                //将之前传的nickname等从redis中取出
                String s = redisService.get(NEW_USER_MSG);
                Member member2 = JSONUtil.toObject(s, Member.class);
                member.setNickname(member2.getNickname());
                member.setGender(member2.getGender());
                member.setCity(member2.getCity());
                //将member加入到数据库中
                Integer i = memberMapper.insert(member);
                //将member存入redis中
                String memberString = JSONUtil.toJsonString(member);
                String setResult = redisService.set(REDIS_KEY, memberString);
                if(OK.equals(setResult) && null != i){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public Boolean newUser(Member member,RedisService redisService){
        try {
            String s = JSONUtil.toJsonString(member);
            String setResult = redisService.set(NEW_USER_MSG, s);
            if (OK.equals(setResult)){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 查询balance
     * @param redisService
     * @return
     */

    public Double selectBalance(RedisService redisService){
       try{
        String memberString = redisService.get(REDIS_KEY);
        Member member = JSONUtil.toObject(memberString, Member.class);
        Member one = memberMapper.selectOne(member);
        Double memberBalance = one.getMemberBalance();
        if (null != memberBalance){
            return memberBalance;
        }
       }catch (Exception e) {
           e.printStackTrace();
       }
       return null;
    }

    /**
     * 支付成功后修改余额
     * @param number
     * @param redisService
     */
    public Integer updateBalance(Double number,RedisService redisService){
        try{
            String memberString = redisService.get(REDIS_KEY);
            Member member = JSONUtil.toObject(memberString, Member.class);
            Long id = member.getId();
            UpdateBalance ub = new UpdateBalance();
            ub.setId(id);
            ub.setNumber(number);
            Integer i = memberMapper.updateBalance(ub);
            if (null!=i){
                return i;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 通过用户名查询信息 总积分
     */

    public Integer selectById(RedisService redisService){
        String user = redisService.get(REDIS_KEY);

        Member member = JSONUtil.toObject(user, Member.class);

        Member member1 = memberMapper.selectByPrimaryKey(member.getId());

        Integer integration = member1.getIntegration();


        return integration;
    }
    /**
     *
     * @param birthday
     * @param id
     * @return
     */
    public int updateBirthday(Date birthday, Long id) {
        Map<String, Object> map = new HashMap();
        map.put("birthday",birthday);
        map.put("id",id);
        int i = memberMapper.updateBir(map);
        return i;

    }
}
