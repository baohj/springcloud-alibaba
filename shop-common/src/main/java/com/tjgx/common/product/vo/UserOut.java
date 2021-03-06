package com.tjgx.common.product.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
*@Description:
*@Author: 鲍红建
*@date: 2020/12/28
*/
@Data
@ApiModel
public class UserOut {

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("手机号")
    private String telephone;
}
