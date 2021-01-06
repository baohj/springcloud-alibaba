package com.tjgx.common.product.exception;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 83495
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @Value("${spring.application.name}")
    private String  projectName;

    @ResponseBody
    @ExceptionHandler
    public Object allExceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        /**
         * 默认返回系统错误
         */
        Result rs = new Result(ErrorCode.MYB_111111.getCode(), ErrorCode.MYB_111111.getDes());
        if (e instanceof MyException) {
            MyException my = (MyException) e;
            ErrorCode errorCode = my.getErrorCode();
            rs = new Result(errorCode.getCode(), errorCode.getDes());
        }
        log.error("全局异常统一处理:", e);
        log.info("@响应参数:{}",JSON.toJSONString(rs));
        log.error("@========================end-{}========================",projectName);
        return rs;
    }

}
