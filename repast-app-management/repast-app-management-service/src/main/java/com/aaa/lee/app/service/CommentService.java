package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Comment;
import com.aaa.lee.app.domain.CommentVo;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.mapper.CommentMapper;
import com.aaa.lee.app.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/20 12:12
 * @Description
 **/
@Service
public class CommentService extends BaseService<Comment> {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Mapper<Comment> getMapper() {
        return commentMapper;
    }

    /**
     * 查询
     * @return
     */
    public List<CommentVo> doComment(String token,MemberService memberService) {
        try {
            if (null != token) {
                Member member = memberService.Token(token);
                if (null != member.getToken()) {
                    Long memberId = member.getId();
                    List<CommentVo> doCommentList = commentMapper.getseleteAll(memberId.intValue());
                    if (null != doCommentList){
                        return doCommentList;
                    }
                    return null;
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;

    }

    /**
     * 删除
     * @param id
     * @return
     */

    public Integer deleteComment(Integer id,String token,MemberService memberService){
        try {
            if (null!=token){
                Member member = memberService.Token(token);
                if (null != member.getToken()) {
                    Integer integer = super.deleteByPrimaryKey(id);
                    if (null!=integer){
                        return integer;
                    }
                    return null;
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 添加评价
     * @param comment
     * @param token
     * @param memberService
     * @return
     */
   public  Integer addComment (Comment comment,String token,MemberService memberService){

       try {
           if (null!=token){
               Member member = memberService.Token(token);
               if (null != member.getToken()) {
                   SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
                   Date date=dateFormat.parse(dateFormat.format(new Date()));
                   comment.setCreateTime(date);
                   Integer save = super.save(comment);
                   if (null!=save){
                       return save;
                   }
                   return null;
               }
               return null;
               }
          return null;
       } catch (Exception e) {
           e.printStackTrace();
       }
       return  null;
   }

    /***
     * 评价数量
     */
   public  Integer Count(String token,MemberService memberService){
       try {
           if (null!=token){
               Member member = memberService.Token(token);
               if (null != member.getToken()) {
                   int count = commentMapper.getCount(member.getId().intValue());
                   if (count>0){
                       return count;
                   }
                   return null;
               }
                return null;
               }
           return null;
       }catch (Exception e){
           e.printStackTrace();
       }
       return null;

   }



}
