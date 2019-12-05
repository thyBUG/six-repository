package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Comment;
import com.aaa.lee.app.domain.CommentReplay;
import com.aaa.lee.app.domain.CommentVo;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.mapper.CommentMapper;
import com.aaa.lee.app.mapper.CommentReplayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class CommentReplayService extends BaseService<CommentReplay> {

    @Autowired
    private CommentReplayMapper commentReplayMapper;

    @Override
    public Mapper<CommentReplay> getMapper() {
        return commentReplayMapper;
    }

    /**
     * 查询
     * @return
     */
    public List<CommentReplay> doCommentReplay(Integer commentId,String token,MemberService memberService){

        try {
            if (null!=token){
                Member member = memberService.Token(token);
                if (null != member.getToken()) {

                    List<CommentReplay> commentReplays = commentReplayMapper.selectsAll(commentId);
                    if (null!=commentReplays){
                        return commentReplays;
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


    /**
     * 添加
     * @return
     */
    public Integer addCommentReplay(CommentReplay commentReplay,String token,MemberService memberService){


        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
           try {
                if (null!=token){
                    Member member = memberService.Token(token);
                    if (null != member.getToken()) {
                        Date date=dateFormat.parse(dateFormat.format(new Date()));
                        commentReplay.setCreateTime(date);

                        int insert = commentReplayMapper.insert(commentReplay);
                        if (insert>0){
                            return insert;
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


}
