package com.tjgx.order.service.impl;

import com.tjgx.common.product.exception.Result;
import com.tjgx.common.product.feignClient.ProductFeignClient;
import com.tjgx.common.product.feignClient.UserFeignClient;
import com.tjgx.order.entity.Order;
import com.tjgx.order.mapper.OrderMapper;
import com.tjgx.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.signature.qual.IdentifierOrArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
*@Description:
*@Author: 鲍红建
*@date: 2021/1/11
*/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductFeignClient productFeignClient;

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    @GlobalTransactional
    @Transactional
    public Result saveOrder(){
        /**
         * 新增订单
         */
        Order order = new Order();
        order.setOrderId(100);
        order.setNumber(2);
        order.setPrice(new BigDecimal(300));
        order.setProductId(1);
        order.setUserId(1);
        orderMapper.insert(order);
        /**
         * 新增产品
         */
        productFeignClient.saveProduct();
        /**
         * 新增用户
         */
        userFeignClient.saveUser();
        return Result.Ok;
    }
}
