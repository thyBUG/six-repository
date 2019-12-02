package com.aaa.lee.app.fallback;

import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.*;
import com.aaa.lee.app.service.IRepastService;
import com.aaa.lee.app.vo.MemberCouponInfoVo;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/20 11:41
 * @Description
 **/
@Component
public class RepastFallBackFactory implements FallbackFactory<IRepastService> {

    @Override
    public IRepastService create(Throwable throwable) {
        IRepastService repastService = new IRepastService() {
            /**
             * 测试查询所有优惠券熔断数据
             * @param memberId
             * @return
             */
            @Override
            public List<MemberCouponInfoVo> allMemberCouponInfo(Long memberId) {
                System.out.println("测试查询所有优惠券熔断数据");
                return null;
            }

            /**
             * 测试查询所有未使用的熔断数据
             * @param memberId
             * @return
             */
            @Override
            public List<MemberCouponInfoVo> UnusedMemberCouponInfo(Long memberId) {
                System.out.println("测试查询所有未使用的熔断数据");
                return null;
            }

            /**
             * 测试查询所有已使用的熔断数据
             * @param memberId
             * @return
             */
            @Override
            public List<MemberCouponInfoVo> usedMemberCouponInfo(Long memberId) {
                System.out.println("测试查询所有已使用的熔断数据");
                return null;
            }

            /**
             * "测试查询领券中心信息
             * @return
             */
            @Override
            public List<CouponInfo> getCouponCenter() {
                System.out.println("测试查询领券中心信息");
                return null;
            }

            @Override
            public List<MyOrder> GetAllOrders() {
                System.out.println("获取订单信息列表");
                return null;
            }

            @Override
            public Boolean orderCollects(Long orderId) {
                System.out.println("测试订单商品收藏熔断数据");
                return null;
            }

            @Override
            public List<Product> getAllCollects() {
                System.out.println("测试获取收藏信息列表");
                return null;
            }

            @Override
            public Boolean productCollects(Long shopId) {
                System.out.println("测试商品收藏熔断数据");
                return null;
            }

            @Override
            public Boolean doLogin(Member member) {
                System.out.println("测试登录熔断");
                return null;
            }

            @Override
            public Boolean newUser(Member member) {
                System.out.println("存储信息熔断");
                return null;
            }

            @Override
            public Double selectBalance() {
                System.out.println("测试查询余额熔断");
                return null;
            }

            @Override
            public Integer updateBalance(Double number) {
                System.out.println("测试余额变动");
                return null;
            }

            @Override
            public List<Product> selectAll() {
                System.out.println("测试登录熔断数据");
                return null;
            }

            @Override
            public Integer selectById() {
                System.out.println("测试总积分");
                return null;
            }

            @Override
            public List<History> selectId() {
                System.out.println("积分明细");
                return null;
            }

            @Override
            public Boolean upadteMemberBirthByMemberId(Date birthday, Long id) {
                return false;
            }

            @Override
            public Boolean addMemberComplain(MemberComplain memberComplain) {
                return false;
            }

            @Override
            public ResultData doComment(Integer memberId) {
                System.out.println("测试熔断方法");
                return null;
            }
            @Override
            public ResultData deleteComment(Integer id) {
                System.out.println("deleteComment测试");
                return null;
            }

            @Override
            public ResultData addComment(Integer shopId, Integer orderId, Integer productId, String memberNickName, String productName, Integer star, String memberIp,Integer showStatus, String productAttribute, Integer collectCouont, String pics, String memberIcon, Integer replayCount, String conent) {
                System.out.println("测试");
                return null;
            }

            @Override
            public String uploadHead(MultipartFile file) {
                System.out.println("getOrder测试");
                return null;
            }

            @Override
            public String upload(MultipartFile[] file) {
                return null;
            }

            @Override
            public ResultData shopResult(Integer id) {
                return null;
            }

            @Override
            public ResultData doCommentReplay(Integer orderId) {
                System.out.println("回复熔断测试");
                return null;
            }

            @Override
            public Integer addCommentReplay(Integer commentId, String memberNickName, String memberIcon, String content,Integer type) {
                return null;
            }

            @Override
            public Integer doCount(Integer memberId) {
                return null;
            }
        };
        return repastService;
    }
}
