package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.CommentReplay;
import com.aaa.lee.app.service.CommentReplayService;
import com.aaa.lee.app.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CommentReplayController extends BaseController {

   @Autowired
    private CommentReplayService commentReplayService;

   @Autowired
   private CommentService commentService;

    /**
     * 查询评价回复表
     * @param id
     * @return
     */
    @GetMapping("/doCommentReplay")
    public ResultData doCommentReplay(@RequestParam("commentId") Integer commentId,@RequestParam("token") String token){
        System.out.println("jjcnjcj"+"----"+commentId);
        List<CommentReplay> CommentReplayList = commentReplayService.doCommentReplay(commentId.longValue(),token,commentService);
          if (null!=CommentReplayList){
             return success("查询成功",CommentReplayList);
          }else {
             return failed("查询失败");
          }
      }
    /***
     * 评价回复
     * @param commentReplay
     * @return
     */

    @PostMapping("/addCommentReplay")
    public ResultData addCommentReplay(@RequestBody CommentReplay commentReplay,@RequestParam("token") String token) {

        System.out.println("+++++++" + commentReplay.getCommentId());

        Integer result = commentReplayService.addCommentReplay(commentReplay,token,commentService);

        if (null != result) {
            return success("添加成功");
        } else {
            return failed("添加失败");
        }

      }

    }
