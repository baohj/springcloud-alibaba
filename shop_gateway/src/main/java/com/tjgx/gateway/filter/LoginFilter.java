package com.tjgx.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.tjgx.gateway.exception.ErrorCode;
import com.tjgx.gateway.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
*@Description:
*@Author: 鲍红建
*@date: 2021/1/4
*/
@Component
@Slf4j
public class LoginFilter  implements GlobalFilter, Ordered {

    @Autowired
    private ProductFeignClient feignClient;
    /**
     * 执行过滤器中的业务逻辑
     *     对请求参数中的token进行判断
     *      如果存在此参数:代表已经认证成功
     *      如果不存在此参数 : 认证失败.
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        log.info("token = {}",token);
      /*  String list = feignClient.getProduct();
        log.info("网关过滤器调用微服务:{}", JSON.toJSONString(list));*/
        /*if(StringUtils.isEmpty(token)){
            throw new MyException(ErrorCode.MYB_200012);
        }*/
        //继续往下执行
        return chain.filter(exchange);
    }

    /**
     * 指定过滤器优先级，值越小优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
