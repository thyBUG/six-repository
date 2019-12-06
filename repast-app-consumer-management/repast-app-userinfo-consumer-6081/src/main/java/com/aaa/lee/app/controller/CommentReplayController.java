package com.aaa.lee.app.controller;


import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.CommentReplay;
import com.aaa.lee.app.service.IRepastService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@Api(value = "评论回复信息接口",tags = "评论回复信息详细接口")
public class CommentReplayController extends BaseController {
    @Autowired
    private IRepastService iRepastService;


    @GetMapping("/doCommentReplay")
    @ApiOperation(value = "查询评论回复",notes = "执行查询评论回复操作")
    public  ResultData doCommentReplay( Integer commentId, String token) {
        ResultData commentReplays = iRepastService.doCommentReplay(commentId,token);
        System.out.println("dkfhgg" + commentReplays);
        return commentReplays;
    }

        @GetMapping("/addCommentReplay")
        @ApiOperation(value = "评论回复",notes = "执行评论回复操作")
      public  ResultData addCommentReplay(CommentReplay commentReplay, String token) {
            System.out.println("++++++++++++++++"+commentReplay.getCommentId());
            ResultData resultData = iRepastService.addCommentReplay(commentReplay,token);
            return resultData;
        }



}
