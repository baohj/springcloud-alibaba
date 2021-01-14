package com.tjgx.product.controller;


import com.alibaba.fastjson.JSON;
import com.tjgx.common.product.exception.Result;
import com.tjgx.common.product.feignClient.UserFeignClient;
import com.tjgx.common.product.vo.ProductOut;
import com.tjgx.common.product.vo.UserOut;
import com.tjgx.product.entity.Product;
import com.tjgx.product.mapper.ProductMapper;
import com.tjgx.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
@Slf4j
public class ProductApi {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserFeignClient userFeignClient;

    @ApiOperation("获取产品")
    @GetMapping("/getProduct")
    public String getProduct(@RequestHeader("abc") String token){
        log.info("token={}",token);
        List<Product> product = productMapper.selectList(null);
        List<ProductOut> lt = product.stream().map(v -> {
            ProductOut productOut = new ProductOut();
            BeanUtils.copyProperties(v, productOut);
            return productOut;
        }).collect(Collectors.toList());
        return JSON.toJSONString(lt);
    }

    @ApiOperation("获取用户")
    @PostMapping("/getUser")
    public Result<List<UserOut>> getUser(){
        Result<List<UserOut>> result = userFeignClient.getUser();
        return result;
    }

    @ApiOperation("保存产品")
    @PostMapping("/saveProduct")
    public Result saveProduct(){
        return productService.saveProduct();
    }
}
