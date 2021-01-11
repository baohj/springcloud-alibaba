package com.tjgx.common.product.feignClient;

import com.tjgx.common.product.exception.Result;
import com.tjgx.common.product.fallBackFactory.ProductFeignFallbackFactory;
import com.tjgx.common.product.fallBackFactory.UserFeignFallbackFactory;
import com.tjgx.common.product.vo.UserOut;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
*@Description:
*@Author: 鲍红建
*@date: 2021/1/6
*/
@FeignClient(name = "shop-user",path = "/user",fallbackFactory = UserFeignFallbackFactory.class )
public interface UserFeignClient {

    @PostMapping("/getUser")
    Result<List<UserOut>> getUser();

    @PostMapping("/saveUser")
    Result saveUser();
}
