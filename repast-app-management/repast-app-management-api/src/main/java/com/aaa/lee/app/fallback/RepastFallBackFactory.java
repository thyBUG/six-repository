package com.aaa.lee.app.fallback;

import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.service.IRepastService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

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
        };
        return repastService;
    }
}
