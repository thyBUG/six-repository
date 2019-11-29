package com.aaa.lee.app.fallback;

import com.aaa.lee.app.domain.History;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.domain.MyOrder;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.service.IRepastService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

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
        };
        return repastService;
    }
}
