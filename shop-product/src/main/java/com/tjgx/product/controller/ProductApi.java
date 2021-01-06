package com.tjgx.product.controller;


import com.alibaba.fastjson.JSON;
import com.tjgx.common.product.exception.Result;
import com.tjgx.common.product.feignClient.UserFeignClient;
import com.tjgx.common.product.vo.ProductOut;
import com.tjgx.common.product.vo.UserOut;
import com.tjgx.product.entity.Product;
import com.tjgx.product.mapper.ProductMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;


/**
*@Description:
*@Author: 鲍红建
*@date: 2020/12/28
*/
@RestController
@RequestMapping("/product")
@Api(tags = "订单模块【鲍红建】")
public class ProductApi {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserFeignClient userFeignClient;

    @ApiOperation("获取产品")
    @GetMapping("/getProduct")
    public String getProduct(){
        List<Product> product = productMapper.selectList(null);
        List<ProductOut> lt = product.stream().map(v -> {
            ProductOut productOut = new ProductOut();
            BeanUtils.copyProperties(product, productOut);
            return productOut;
        }).collect(Collectors.toList());
        return JSON.toJSONString(lt);
    }

    @ApiOperation("获取用户")
    @GetMapping("/getUser")
    public Result<List<UserOut>> getUser(){
        Result<List<UserOut>> result = userFeignClient.getUser();
        return result;
    }
}
