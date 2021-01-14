package com.tjgx.order.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.tjgx.common.product.exception.Result;
import com.tjgx.common.product.vo.ProductOut;
import com.tjgx.common.product.vo.UserOut;
import com.tjgx.order.dto.GetOrderOut;
import com.tjgx.order.entity.Order;
import com.tjgx.common.product.feignClient.ProductFeignClient;
import com.tjgx.order.mapper.OrderMapper;
import com.tjgx.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
*@Description:
*@Author: 鲍红建
*@date: 2020/12/28
*/
@RestController
@RequestMapping("/order")
@Api(tags = "订单模块【鲍红建】")
@Slf4j
@RefreshScope
public class OrderApi {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductFeignClient productFeignClient;

    @Autowired
    private OrderService orderService;


    @Value("${spring.application.name}")
    private String projectName;

    /**
     * 微服务调用：
     * 方案一缺点：调用接口之前需要知道服务的域名和端口，并且不能支持负载均衡
     */
    @ApiOperation("获取用户")
    @GetMapping("/getOrder/{orderId}")
    public GetOrderOut getOrder(@PathVariable Integer orderId){
        log.info("获取订单信息,入参:orderId = {}",orderId);
        Order order = orderMapper.selectById(orderId);
        log.info("获取订单信息,出参:{}", JSON.toJSONString(order));

        Integer productId = order.getProductId();
        log.info("查询产品信息,入参:productId = {}",productId);
       String  str= restTemplate.getForObject("http://localhost:8081/product/getProduct/"+productId, String.class);
        log.info("查询产品信息,出参:{}",str);
        List<ProductOut> list = JSONArray.parseArray(str, ProductOut.class);

        GetOrderOut getOrderOut = new GetOrderOut();
        BeanUtils.copyProperties(order,getOrderOut);
        getOrderOut.setProductName(list);
        return getOrderOut;
    }

    /**
     * 微服务调用：
     * 方案二缺点：1、代码可读性差；2、代码调用风格不统一
     * @param orderId
     * @return
     */
    @ApiOperation("获取用户")
    @GetMapping("/findOrder/{orderId}")
    public GetOrderOut  findOrder(@PathVariable Integer orderId){
        log.info("获取订单信息,入参:orderId = {}",orderId);
        Order order = orderMapper.selectById(orderId);
        log.info("获取订单信息,出参:{}", JSON.toJSONString(order));

        Integer productId = order.getProductId();
        log.info("查询产品信息,入参:productId = {}",productId);
        String  str= restTemplate.getForObject("http://shop-product/product/getProduct/"+productId, String.class);
        log.info("查询产品信息,出参:{}",str);
        List<ProductOut> list = JSONArray.parseArray(str, ProductOut.class);
        GetOrderOut getOrderOut = new GetOrderOut();
        BeanUtils.copyProperties(order,getOrderOut);
        getOrderOut.setProductName(list);
        return getOrderOut;
    }

    /**
     * 微服务调用：
     * 方案二： 优点：可以像调用本地方法一样调用微服务方法
     * @param orderId
     * @return
     */
    @ApiOperation("获取用户")
    @GetMapping("/fetchOrder/{orderId}")
    public GetOrderOut  fetchOrder(@PathVariable Integer orderId,@RequestHeader("abc") String token){
        log.info("获取订单信息,入参:orderId = {},token={}",orderId,token);
        Order order = orderMapper.selectById(orderId);
        log.info("获取订单信息,出参:{}", JSON.toJSONString(order));

        Integer productId = order.getProductId();
        log.info("查询产品信息,入参:productId = {}",productId);

        String result = productFeignClient.getProduct();

        List<ProductOut> list = JSONArray.parseArray(result, ProductOut.class);

        GetOrderOut getOrderOut = new GetOrderOut();
        BeanUtils.copyProperties(order,getOrderOut);
        getOrderOut.setProductName(list);
        return getOrderOut;
    }

    @ApiOperation("测试Sentinel流控效果")
    @GetMapping("/flowLimit")
    public String  flowLimit(){
        log.info("sentinel 流控效果测试");
        log.info("读取配置:{}",projectName);
        return "flowLimit";
    }

    @ApiOperation("测试返回异常")
    @GetMapping("/throwException")
    public String  throwException(){
        if(true){
            int i = 9/0;
        }
        return "throwException";
    }


    @ApiOperation("获取用户")
    @GetMapping("/getUser")
    public Result<List<UserOut>> getUser(){
        Result<List<UserOut>> result = productFeignClient.getUser();
        return result;
    }

    @ApiOperation("保存订单")
    @GetMapping("/saveOrder")
    public Result saveOrder(){
        return orderService.saveOrder();
    }


}
