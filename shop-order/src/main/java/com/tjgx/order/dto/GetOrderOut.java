package com.tjgx.order.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
*@Description:
*@Author: 鲍红建
*@date: 2020/12/29
*/
@Data
@ApiModel
public class GetOrderOut {
    @ApiModelProperty("订单id")
    private Integer orderId;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("产品id")
    private Integer productId;

    @ApiModelProperty("产品单价")
    private BigDecimal price;

    @ApiModelProperty("购买数量")
    private Integer number;

    @ApiModelProperty("产品名称")
    private String productName;

}
