package com.tjgx.common.product.fallBackFactory;

import com.tjgx.common.product.exception.Result;
import com.tjgx.common.product.feignClient.UserFeignClient;
import com.tjgx.common.product.vo.UserOut;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
*@Description:
*@Author: 鲍红建
*@date: 2021/1/6
*/
@Component
@Slf4j
public class UserFeignFallbackFactory implements FallbackFactory<UserFeignClient> {
    @Override
    public UserFeignClient create(Throwable throwable) {
        log.error("远程接口异常:",throwable);
        return new UserFeignClient(){
            @Override
            public Result<List<UserOut>> getUser() {
                return null;
            }
        };
    }
}
