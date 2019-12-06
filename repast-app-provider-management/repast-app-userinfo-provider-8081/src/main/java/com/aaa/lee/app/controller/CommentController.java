package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Comment;
import com.aaa.lee.app.service.CommentService;
import com.aaa.lee.app.vo.MemberCommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController extends BaseController {

    @Autowired
    private CommentService commentService;
    /**
     * 查询评价表
     *
     * @param id
     * @return
     */
    @GetMapping("/doComment")
   public ResultData doComment(@RequestParam("token") String token) {
        List<MemberCommentVo> memberCommentVos = commentService.doComment(token);
        if (null != memberCommentVos) {
                return success("查询成功", memberCommentVos);
            } else {
                return failed("查询失败");
            }
    }
    /**
     * 删除评价回复表
     * @param id
     * @return
     */
    @GetMapping("/deleteComment")
    public ResultData deleteComment(@RequestParam("id") Integer id,@RequestParam("token") String token) {
        System.out.println("ppppp" + id);
        Integer integer = commentService.deleteComment(id, token);
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
    @PostMapping("/addComment")
   public ResultData addComment(@RequestBody Comment comment,@RequestParam("token") String token) {
        System.out.println("---------------------------" + comment.getShopId());
        Integer integer = commentService.addComment(comment, token);
        if (null!=integer) {
            return success("添加成功");
        } else {
            return failed("添加失败");
        }
    }

    @GetMapping("/doCount")
   public Integer doCount(@RequestParam("token") String token) {

        Integer count = commentService.Count(token);
        return count;
    }





}