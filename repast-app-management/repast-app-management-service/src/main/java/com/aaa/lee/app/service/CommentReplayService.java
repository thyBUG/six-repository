package com.aaa.lee.app.service;
import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.CommentReplay;
import com.aaa.lee.app.domain.Member;
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
    public List<CommentReplay> doCommentReplay(Long commentId,String token,CommentService commentService){

        try {
            Member member = commentService.Token(token);
            List<CommentReplay> commentReplays = commentReplayMapper.selectsAll(commentId);
                    if (null!=commentReplays){
                        return commentReplays;
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
    public Integer addCommentReplay(CommentReplay commentReplay,String token,CommentService commentService){


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           try {
               Member member = commentService.Token(token);
               Date date=dateFormat.parse(dateFormat.format(new Date()));
                        commentReplay.setCreateTime(date);
                        int insert = commentReplayMapper.insert(commentReplay);
                        if (insert>0){
                            return insert;
                         }
                    return null;
              } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }


}
