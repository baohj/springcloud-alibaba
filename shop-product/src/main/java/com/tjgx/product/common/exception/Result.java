package com.tjgx.product.common.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class Result<T> {
    @ApiModelProperty(value = "响应码，000000 表示成功;其他为请求失败")
    private String code;

    @ApiModelProperty(value = "响应描述信息")
    private String des;

    @ApiModelProperty(value = "响应数据")
    private T resData;

    public static Result Ok = new Result(ErrorCode.MYB_000000.getCode(),ErrorCode.MYB_000000.getDes());

    public static Result success(Object data){
        Result result = new Result(ErrorCode.MYB_000000.getCode(),ErrorCode.MYB_000000.getDes(),data);
        return result;
    }
    /**
     *
     * @param code 错误码
     * @param des  错误描述信息
     * @param resData  服务器的响应数据
     */
    public Result(String code,String des,T resData){
        this.code = code;
        this.des = des;
        this.resData = resData;
    }

    /**
     *
     * @param code 错误码
     * @param des 错误描述信息
     */
    public Result(String code,String des){
        this.code = code;
        this.des = des;
    }



}
