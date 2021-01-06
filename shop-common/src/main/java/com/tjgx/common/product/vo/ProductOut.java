package com.tjgx.common.product.vo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.math.BigDecimal;

/**
 *@Description: $
 *@Param: $
 *@return: $
 *@Author: 鲍红建
 *@date: $
 */
@Data
@ApiModel
public class ProductOut {

    @ApiModelProperty("产品id")
    private Integer productId;

    @ApiModelProperty("产品名称")
    private String productName;

    @ApiModelProperty("产品单价")
    private BigDecimal price;

    @ApiModelProperty("产品库存")
    private Integer stock;
}
