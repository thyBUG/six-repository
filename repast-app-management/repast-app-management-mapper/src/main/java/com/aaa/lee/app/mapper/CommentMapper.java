package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.Comment;
import com.aaa.lee.app.domain.CommentVo;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.vo.CommentProVo;
import com.aaa.lee.app.vo.MemberCommentVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/20 12:12
 * @Description
 **/
public interface CommentMapper extends Mapper<Comment> {

     List<MemberCommentVo> getseleteAll(Integer memberId);


     int getCount(Integer id);



     Member Token(String token);


     List<CommentProVo>  selectProComment(Long orderId);


     /**
      * 通过评价主键id
      * @param id
      * @return
      */
     int updateCommentStatus(Long id);


}
