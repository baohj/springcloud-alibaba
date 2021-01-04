package com.tjgx.product.common.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.tjgx.common.product.exception.ErrorCode;
import com.tjgx.common.product.exception.MyException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * sentinel 限流，熔断降级 异常处理
 * @author 83495
 */
@Component
public class SentinelExceptionConfig implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) {
    if (e instanceof FlowException) {
        throw  new MyException(ErrorCode.MYB_111002);
    } else if (e instanceof DegradeException) {
        throw  new MyException(ErrorCode.MYB_111004);
    } else if (e instanceof ParamFlowException) {
        throw  new MyException(ErrorCode.MYB_200001);
    } else if (e instanceof AuthorityException) {
        throw  new MyException(ErrorCode.MYB_200003);
    } else if (e instanceof SystemBlockException) {
        throw  new MyException(ErrorCode.MYB_200004);
    }
    }
}
