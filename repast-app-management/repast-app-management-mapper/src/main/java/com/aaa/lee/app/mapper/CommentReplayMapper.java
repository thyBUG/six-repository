package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.CommentReplay;
import com.aaa.lee.app.domain.MemberCommentReplay;
import com.aaa.lee.app.vo.MemberCommentVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CommentReplayMapper extends Mapper<CommentReplay> {


    List<CommentReplay> selectsAll(Long commentId);

}