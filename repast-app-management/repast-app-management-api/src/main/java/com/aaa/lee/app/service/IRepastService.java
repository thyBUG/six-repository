package com.aaa.lee.app.service;

import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.config.FeignMultipartSupportConfig;
import com.aaa.lee.app.domain.*;
import com.aaa.lee.app.fallback.RepastFallBackFactory;
import com.aaa.lee.app.vo.MemberCouponInfoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/20 11:40
 * @Description
 *      当使用feign进行传参的时候，如果是对象,包装类型,实体类...必须要使用@RequestBody，并且这个@RequestBody只能在该方法中出现一次
 *          ResultData selectUsersCondition(@RequestBody User user, @RequestBody UserInfo userInfo);---->错误
 *      当传递的参数是简单类型(String, Integer....8种基本类型+String)，必须要使用@RequestParam("")，这个@RequestPara注解可以出现多个
 *          ResultData selectUsersCondition(@RquestPara("username") String username, @RequestParam("age") Integer age);---->正确
 *
 **/
@FeignClient(value = "userinfo-interface-provider", fallbackFactory = RepastFallBackFactory.class,configuration =FeignMultipartSupportConfig.class)
public interface IRepastService {


    /**
     * 获取所有订单信息列表
     * @return
     */
    @GetMapping("/getAllOrder")
    List<MyOrder> GetAllOrders(@RequestParam(value = "token") String token);
    /**
     * 填写订单的时候执行收藏操作
     * @param orderId
     * @param  token
     * @return
     */
    @PostMapping("/oCollect")
    Boolean orderCollects(@RequestParam(value = "orderId") Long orderId,@RequestParam(value = "token") String token);
    /**
     * 获取收藏列表信息
     * @param token
     * @return
     */
    @GetMapping("/getAllCollect")
    List<Product> getAllCollects(@RequestParam(value = "token") String token);
    /**
     *浏览商品执行添加收藏操作
     * @param shopId
     * @param token
     * @return
     */
    @PostMapping("/pCollect")
    Boolean productCollects(@RequestParam(value = "shopId") Long shopId,@RequestParam(value = "token") String token);



    /**
     * 执行登录
     * @param member
     * @return
     */
    @PostMapping("/login")
    Boolean doLogin(@RequestBody Member member);

    /**
     * 接收用户信息
     * @param member
     * @return
     */
    @PostMapping("/userMessage")
    Boolean newUser(@RequestBody Member member);

    /**
     * 执行查询余额
     * @return
     */
   @PostMapping("/selectBalance")
    Double selectBalance();

    /**
     * 充值后改变余额
     */
   @PostMapping("/updateBalance")
    Integer updateBalance(@RequestParam("number") Double number);
    /**
     * 查询积分商城可兑换的商品信息
     * @return
     */
    @PostMapping("/selectAll")
    List<Product> selectAll();

    /**
     * 查询总积分
     */
    @PostMapping("/selectById")
    Integer selectById();

    /**
     * 查询积分明细
     *
     */
    @PostMapping("/selectId")
    List<History> selectId();

    /**
     * @author Seven Lee
     * @description
     *      根据会员id获取会员生日
     * @param []
     * @date 2019/11/21
     * @return java.util.List<com.aaa.lee.app.domain.MemberReceiveAddress>
     * @throws
     **/
    @PostMapping ("/updateBirth")
    Boolean upadteMemberBirthByMemberId(@RequestParam("birthday") Date birthday, @RequestParam("id") Long id);


    /**
     * @author Seven Lee
     * @description
     *      增加意见反馈
     * @param []
     * @date 2019/11/21
     * @return java.util.List<com.aaa.lee.app.domain.MemberReceiveAddress>
     * @throws
     **/
    @PostMapping("/addcomplain")
    Boolean addMemberComplain(@RequestBody MemberComplain memberComplain);

    /***
     * 查看评价
     * @param memberId
     * @return
     */
    @GetMapping("/doComment")
    ResultData doComment(@RequestParam("token") String token,MemberService memberService);

    /***
     * 删除评价
     * @param id
     * @return
     */
    @GetMapping("/deleteComment")
    ResultData deleteComment(@RequestParam("id") Integer id,@RequestParam("token") String token,MemberService memberService);

    /***
     * 添加评价
     * @return
     */
    @GetMapping("/addComment")
    ResultData addComment(@RequestParam("shopId")  Integer shopId, @RequestParam("orderId") Integer orderId, @RequestParam("roductId") Integer productId,
                          @RequestParam("memberNickName") String memberNickName, @RequestParam("productName") String productName, @RequestParam("star") Integer star, @RequestParam("memberIp") String memberIp,
                          @RequestParam("showStatus") Integer showStatus, @RequestParam("productAttribute") String productAttribute, @RequestParam("collectCouont") Integer collectCouont,
                          @RequestParam("pics") String pics, @RequestParam("memberIcon") String memberIcon, @RequestParam("replayCount") Integer replayCount, @RequestParam("conent") String conent,
                          @RequestParam("token") String token,MemberService memberService);

    /**
     * 单添加图片
     * @param file
     * @return
     */

    @PostMapping(value = "/uploadHead",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadHead(@RequestPart MultipartFile file);


    /***
     * 多张图片上传
     * @param file
     * @return
     */

    @PostMapping(value = "/upload",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
     String upload(@RequestPart(value = "file") MultipartFile[]  file);
    /**
     * 根据 订单ID查点铺信息
     * @param id
     * @return
     */
    @GetMapping("/shop")
    ResultData shopResult(@RequestParam("shopId") Integer id,@RequestParam("token") String token,MemberService memberService);

    /***
     * 查询评价回复表
     * @param id
     * @param orderId
     * @return
     */

    @GetMapping("/doCommentReplay")
    ResultData doCommentReplay(@RequestParam("commentId") Integer commentId,@RequestParam("token") String token,MemberService memberService);

    /***
     * 评价回复表
     * @param commentReplay
     * @return
     */
    @PostMapping("/addCommentReplay")
    ResultData addCommentReplay(@RequestParam("commentId") Integer commentId,@RequestParam("memberNickName") String memberNickName,
                             @RequestParam("memberIcon") String memberIcon,@RequestParam("content") String content,
                             @RequestParam("type") Integer type,@RequestParam("token") String token,MemberService memberService);




    /***
     * 评价数目
     * @param commentReplay
     * @return
     */

    @GetMapping("/doCount")
    Integer doCount(@RequestParam("token") String token,MemberService memberService);



    /**
     * 查询所有优惠券信息
     * @param memberId
     * @return
     */
    @PostMapping("/allCoupon")
    List<MemberCouponInfoVo> allMemberCouponInfo(@RequestParam("memberId") Long memberId);

    /**
     * 查询所有未使用优惠券信息
     * @param memberId
     * @return
     */
    @PostMapping("/allUnusedCoupon")
    List<MemberCouponInfoVo> UnusedMemberCouponInfo(@RequestParam("memberId") Long memberId);

    /**
     * 查询所有已使用优惠券信息
     * @param memberId
     * @return
     */
    @PostMapping("/allUsedCoupon")
    List<MemberCouponInfoVo> usedMemberCouponInfo(@RequestParam("memberId") Long memberId);

    /**
     * 领券中心信息
     * @return
     */
    @PostMapping("/getCoupon")
    List<CouponInfo> getCouponCenter();

}
