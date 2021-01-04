package com.tjgx.gateway.MyPredicate;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
*@Description:自定义断言
*@Author: 鲍红建
*@date: 2021/1/4
*/
@Component
@Slf4j
public class AgeCheckRoutePredicateFactory extends AbstractRoutePredicateFactory<AgeCheckRoutePredicateFactory.Config> {

    public AgeCheckRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        /**
         * 接收配置，需要按顺序，- AgeCheck=18,30
         */
        return Arrays.asList("minAge","maxAge");
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return ServerWebExchange ->{
            String age = ServerWebExchange.getRequest().getQueryParams().getFirst("age");
            log.info("age = {}",age);
            if(StringUtils.isEmpty(age)){
                return false;
            }
            Integer ageInt = Integer.valueOf(age);
            if(ageInt >= config.getMinAge() && ageInt <= config.getMaxAge()){
                return true;
            }
            return false;
        };
    }

    @Data
    public static class Config {
        private int minAge;
        private int maxAge;
    }

}

