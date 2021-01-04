package com.tjgx.gateway.exception;


import lombok.Data;

@Data

public class Result<T> {
    private String code;

    private String des;

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
