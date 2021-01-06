package com.tjgx.gateway.filter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
*@Description:
*@Author: 鲍红建
*@date: 2020/12/29
*/
@FeignClient(name = "shop-product",path = "/product")
public interface ProductFeignClient {


    @GetMapping("/getProduct")
    String getProduct();


}
