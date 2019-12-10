package com.aaa.lee.app.controller;
import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Comment;
import com.aaa.lee.app.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "评论信息接口",tags = "评论信息详细接口")
public class CommentController extends BaseController {

    @Autowired
    private IRepastService iRepastService;

    @GetMapping("/do")
    @ApiOperation(value = "评论",notes = "执行评论操作")
    public ResultData doComment(String token){
        ResultData commentVos = iRepastService.doComment(token);
        System.out.println("kjsdhnsk"+commentVos);
        return commentVos;
    }


    @GetMapping("/delete")
    @ApiOperation(value = "删除评论",notes = "执行删除评论操作")
    public ResultData deleteComment(Integer id,String token) {
        System.out.println("cccccccccccc"+token);
        ResultData resultData = iRepastService.deleteComment(id,token);
        return resultData;
    }

        @PostMapping("/addComment")
        @ApiOperation(value = "添加数据评价接口",notes = "执行添加数据评价接口操作")
     public   ResultData addComment(Comment comment,String token){
            System.out.println("skjdbgvjdgbfbfkb"+comment.getShopId());
            ResultData resultData = iRepastService.addComment(comment,token);
            return resultData;
        }

    /***
     * 查询评价数目
     * @param memberId
     * @return
     */
    @GetMapping("/doCount")
    @ApiOperation(value = "评价数目接口",notes = "执行评价数目接口操作")
    public ResultData doCount(String token){
        Integer integer = iRepastService.doCount(token);
        return success("查询成功",integer);
    }



}
