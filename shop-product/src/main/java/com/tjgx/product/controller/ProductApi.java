package com.tjgx.product.controller;


import com.alibaba.fastjson.JSON;
import com.tjgx.product.entity.Product;
import com.tjgx.product.mapper.ProductMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


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


    @ApiOperation("获取用户")
    @GetMapping("/getProduct/{productId}")
    public String getProduct(@PathVariable(value = "productId") Integer productId){
        Product product = productMapper.selectById(productId);
        return JSON.toJSONString(product);
    }

}
