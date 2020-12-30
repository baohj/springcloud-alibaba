package com.tjgx.product.entity;

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
@ApiModel
@TableName("tjgx_product")
public class Product {

    @TableId(type = IdType.AUTO)
    private Integer productId;


    private String productName;


    private BigDecimal price;


    private Integer stock;
}
