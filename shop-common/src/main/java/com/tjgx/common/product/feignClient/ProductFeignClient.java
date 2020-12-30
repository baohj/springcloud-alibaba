package com.tjgx.common.product.feignClient;

import com.tjgx.common.product.fallBackFactory.ProductFeignFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
*@Description:
*@Author: 鲍红建
*@date: 2020/12/29
*/
@FeignClient(name = "shop-product",path = "/product",fallbackFactory = ProductFeignFallbackFactory.class )
public interface ProductFeignClient {


    @GetMapping("/getProduct/{productId}")
    String getProduct(@PathVariable(value = "productId") Integer productId);
}
