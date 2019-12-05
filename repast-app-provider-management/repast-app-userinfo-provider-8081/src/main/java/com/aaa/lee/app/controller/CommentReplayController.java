package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.CommentReplay;
import com.aaa.lee.app.service.CommentReplayService;
import com.aaa.lee.app.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CommentReplayController extends BaseController {

   @Autowired
    private CommentReplayService commentReplayService;

   @Autowired
   private MemberService memberService;


    /**
     * 查询评价回复表
     * @param id
     * @return
     */
    @GetMapping("/doCommentReplay")
    public ResultData doCommentReplay(@RequestParam("commentId") Integer commentId,@RequestParam("token") String token,MemberService memberService){
        System.out.println("jjcnjcj"+"----"+commentId);
        List<CommentReplay> CommentReplayList = commentReplayService.doCommentReplay(commentId,token,memberService);
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
    public ResultData addCommentReplay(@RequestParam("commentId") Integer commentId,@RequestParam("memberNickName") String memberNickName,
                               @RequestParam("memberIcon") String memberIcon,@RequestParam("content") String content,
                               @RequestParam("type") Integer type,@RequestParam("token") String token,MemberService memberService) {

        System.out.println("+++++++" + commentId);

        CommentReplay commentReplay = new CommentReplay();
        commentReplay.setCommentId(commentId.longValue());
        commentReplay.setMemberNickName(memberNickName);
        commentReplay.setMemberIcon(memberIcon);
        commentReplay.setContent(content);
        commentReplay.setType(type);

        Integer result = commentReplayService.addCommentReplay(commentReplay, token, memberService);

        if (null != result) {
            return success("添加成功");
        } else {
            return failed("添加失败");
        }

      }

    }
