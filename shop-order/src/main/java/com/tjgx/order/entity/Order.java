package com.tjgx.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
*@Description:
*@Author: 鲍红建
*@date: 2020/12/28
*/
@Data
@TableName("tjgx_order")
public class Order {

    @TableId(type=IdType.AUTO)
    private Integer orderId;

    private Integer userId;

    private Integer productId;

    private BigDecimal price;

    private Integer number;

}
