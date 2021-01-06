package com.tjgx.common.product.feignClient;

import com.tjgx.common.product.exception.Result;
import com.tjgx.common.product.fallBackFactory.ProductFeignFallbackFactory;
import com.tjgx.common.product.vo.ProductOut;
import com.tjgx.common.product.vo.UserOut;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
*@Description:
*@Author: 鲍红建
*@date: 2020/12/29
*/
@FeignClient(name = "shop-product",path = "/product",fallbackFactory = ProductFeignFallbackFactory.class )
public interface ProductFeignClient {


    @PostMapping("/getProduct")
    String getProduct();

    @PostMapping("/getUser")
    Result<List<UserOut>> getUser();
}
