package com.tjgx.order.service.impl;

import com.tjgx.common.product.exception.Result;
import com.tjgx.order.entity.Order;
import com.tjgx.order.mapper.OrderMapper;
import com.tjgx.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Result saveOrder(){
        Order order = new Order();
        orderMapper.insert(order);
        return Result.Ok;
    }
}
