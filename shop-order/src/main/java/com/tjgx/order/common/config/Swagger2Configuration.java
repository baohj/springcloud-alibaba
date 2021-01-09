package com.tjgx.order.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
*@Description:
*@Author: 鲍红建
*@date: 2020/12/28
*/
@Configuration
@EnableSwagger2
public class Swagger2Configuration {


    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf());

    }

    private ApiInfo buildApiInf() {

        return new ApiInfoBuilder()
                .title("电商订单系统")
                .build();
    }



}
