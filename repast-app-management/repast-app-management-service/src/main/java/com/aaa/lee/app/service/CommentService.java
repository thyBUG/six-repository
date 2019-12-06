package com.aaa.lee.app.service;
import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.*;
import com.aaa.lee.app.mapper.CommentMapper;
import com.aaa.lee.app.mapper.CommentReplayMapper;
import com.aaa.lee.app.vo.CommentProVo;
import com.aaa.lee.app.vo.MemberCommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
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

    @Autowired
    private  CommentReplayMapper commentReplayMapper;

    @Override
    public Mapper<Comment> getMapper() {
        return commentMapper;
    }

    /**
     * 查询
     * @return
     */
    public List<MemberCommentVo> doComment(String token) {
        try {
            Member member = Token(token);
            Long memberId = member.getId();
            List<MemberCommentVo> memberCommentVos = commentMapper.getseleteAll(memberId.intValue());
            if (null != memberCommentVos){
                for (MemberCommentVo mcm : memberCommentVos){
                    Long orderId = mcm.getOrderId();
                    Long commentId = mcm.getId();
                    Long productId = mcm.getProductId();
                    // 通过订单id查询该商品的所属的商品信息
                    List<CommentProVo> commentProVos = commentMapper.selectProComment(orderId);
                    // 判断该评价信息中商品id是否为空
                    if(null == productId){
                        System.out.println("该订单为多个商品");
                        // 如果为空，则把商品信息存放到该订单所属的评价里
                        mcm.setMemberCommentVos(commentProVos);
                    }else{
                        // 如果不为空，继续执行；
                        continue;
                    }
                    List<CommentReplay> commentReplays = commentReplayMapper.selectsAll(commentId);
                    // 把回复信息存放到评价里
                    mcm.setCommentReplays(commentReplays);
                        }
                        return memberCommentVos;
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

    public Integer deleteComment(Integer id,String token){
        try {
                    Member member = Token(token);
                    Integer integer = commentMapper.updateCommentStatus(id.longValue());
                    if (null!=integer){
                        return integer;
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
     * @param commentmapper
     * @return
     */
   public  Integer addComment (Comment comment,String token) {
       try {
           Member member = Token(token);
           Long orderId = comment.getOrderId();
           List<CommentProVo> commentProVos = commentMapper.selectProComment(orderId);
           System.out.println("订单查询" + commentProVos.toString());

               if (commentProVos.size() == 1) {
                   // 如果该订单中为单个商品,则添加到评价表中
                   for (CommentProVo commentProVo : commentProVos) {
                       Long productId = commentProVo.getProductId();
                       String productName = commentProVo.getProductName();
                       String name = commentProVo.getName();
                       comment.setOrderId(orderId);
                       comment.setProductId(productId);
                       comment.setProductName(productName);
                       comment.setProductAttribute(name);
                   }
                }
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           Date date = dateFormat.parse(dateFormat.format(new Date()));
           comment.setCreateTime(date);
           Integer save = super.save(comment);
           if (null != save) {
               return save;
           }
            return null;
           } catch(Exception e){
               e.printStackTrace();
           }
           return null;
       }


    /***
     * 评价数量
     */
   public  Integer Count(String token){
       try {
           Member member = Token(token);
           int count = commentMapper.getCount(member.getId().intValue());
                   if (count>0){
                       return count;
                   }
           return null;
       }catch (Exception e){
           e.printStackTrace();
       }
       return null;

   }


    /**
     * 通过token判断登陆状态，并查询memberId
     * @param token
     * @return
     */


   public  Member Token(String token){
       if (null!=token){
           Member member = commentMapper.Token(token);
           if (null != member.getToken()) {
               return member;
               }
               return null;
           }
       return null;
   }



}
