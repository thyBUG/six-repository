package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Comment;
import com.aaa.lee.app.domain.CommentVo;
import com.aaa.lee.app.service.CommentService;
import com.aaa.lee.app.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController extends BaseController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private MemberService memberService;

    private Comment comment = new Comment();

    /**
     * 查询评价表
     *
     * @param id
     * @return
     */
    @GetMapping("/doComment")
   public ResultData doComment(@RequestParam("token") String token,MemberService memberService) {
        List<CommentVo> doCommentList =  commentService.doComment(token, memberService);

            if (null != doCommentList) {
                return success("查询成功", doCommentList);
            } else {
                return failed("查询失败");
            }
    }
    /**
     * 删除评价回复表
     *
     * @param id
     * @return
     */
    @GetMapping("/deleteComment")
    public ResultData deleteComment(@RequestParam("id") Integer id,@RequestParam("token") String token,MemberService memberService) {
        System.out.println("ppppp" + id);
        Integer integer = commentService.deleteComment(id, token, memberService);
        if (null!=integer) {
            return success("删除成功");
        } else {
            return failed("删除失败");
        }
    }

    /**
     * 添加评价
     *
     * @param comment
     * @return
     */
    @GetMapping("/addComment")
   public ResultData addComment(@RequestParam("shopId") Integer shopId, @RequestParam("orderId") Integer orderId, @RequestParam("roductId") Integer productId,
                          @RequestParam("memberNickName") String memberNickName, @RequestParam("productName") String productName, @RequestParam("star") Integer star, @RequestParam("memberIp") String memberIp,
                          @RequestParam("showStatus") Integer showStatus, @RequestParam("productAttribute") String productAttribute, @RequestParam("collectCouont") Integer collectCouont,
                          @RequestParam("pics") String pics, @RequestParam("memberIcon") String memberIcon, @RequestParam("replayCount") Integer replayCount, @RequestParam("conent") String conent,@RequestParam("token") String token,MemberService memberService) {
        System.out.println("---------------------------" + shopId.byteValue());
        comment.setShopId(shopId.longValue());
        comment.setOrderId(orderId.longValue());
        comment.setProductId(productId.longValue());
        comment.setMemberNickName(memberNickName);
        comment.setProductName(productName);
        comment.setStar(star);
        comment.setMemberIp(memberIp);
        comment.setShowStatus(showStatus);
        comment.setProductAttribute(productAttribute);
        comment.setCollectCouont(collectCouont);
        comment.setPics(pics);
        comment.setMemberIcon(memberIcon);
        comment.setReplayCount(replayCount);
        comment.setContent(conent);


        Integer integer = commentService.addComment(comment, token, memberService);
        if (null!=integer) {
            return success("添加成功");
        } else {
            return failed("添加失败");
        }
    }

    @GetMapping("/doCount")
   public Integer doCount(@RequestParam("token") String token,MemberService memberService) {

        Integer count = commentService.Count(token, memberService);
        return count;
    }


}