package com.aaa.lee.app.controller;


import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.*;
import com.aaa.lee.app.service.IRepastService;
import com.aaa.lee.app.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
@Api(value = "评论信息接口",tags = "评论信息详细接口")
public class CommentController extends BaseController {
    @Autowired
    private IRepastService iRepastService;

    @GetMapping("/do")
    @ApiOperation(value = "评论",notes = "执行评论操作")
    public ResultData doComment(@RequestParam("token") String token,MemberService memberService){
        ResultData commentVos = iRepastService.doComment(token,memberService);
        System.out.println("kjsdhnsk"+commentVos);
        return commentVos;
    }


    @GetMapping("/delete")
    @ApiOperation(value = "删除评论",notes = "执行删除评论操作")
    public ResultData deleteComment(@RequestParam("id") Integer id,@RequestParam("token") String token,MemberService memberService) {
        System.out.println("cccccccccccc"+token);
        ResultData resultData = iRepastService.deleteComment(id,token,memberService);
        return resultData;
    }

        @GetMapping("/addComment")
        @ApiOperation(value = "添加数据接口",notes = "执行添加订单数据接口操作")
     public   ResultData addComment(@RequestParam("shopId")  Integer shopId, @RequestParam("orderId") Integer orderId, @RequestParam("roductId") Integer productId,
                          @RequestParam("memberNickName") String memberNickName, @RequestParam("productName") String productName, @RequestParam("star") Integer star, @RequestParam("memberIp") String memberIp,
                          @RequestParam("showStatus") Integer showStatus, @RequestParam("productAttribute") String productAttribute, @RequestParam("collectCouont") Integer collectCouont,
                          @RequestParam("pics") String pics, @RequestParam("memberIcon") String memberIcon, @RequestParam("replayCount") Integer replayCount, @RequestParam("conent") String conent,
                                    @RequestParam("token") String token,MemberService memberService){
            System.out.println("skjdbgvjdgbfbfkb"+shopId);

            ResultData resultData = iRepastService.addComment(shopId, orderId, productId, memberNickName, productName, star, memberIp,
                    showStatus, productAttribute, collectCouont,
                    pics, memberIcon, replayCount, conent, token, memberService);
            return resultData;
        }

    /***
     * 查询评价数目
     * @param memberId
     * @return
     */
    @GetMapping("/doCount")
    @ApiOperation(value = "评价数目接口",notes = "执行评价数目接口操作")
    public ResultData doCount(@RequestParam("token") String token,MemberService memberService){
        Integer integer = iRepastService.doCount(token, memberService);
        return success("查询成功",integer);

    }



}
