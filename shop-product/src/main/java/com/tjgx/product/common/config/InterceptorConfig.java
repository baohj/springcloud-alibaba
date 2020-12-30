package com.tjgx.order.common.config;

import com.tjgx.order.common.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
*@Description:
*@Author: 鲍红建
*@date: 2020/12/30
*/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor localInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localInterceptor())
                .addPathPatterns("/**");
        //.excludePathPatterns("/web/login**")
        //.excludePathPatterns("/error")
        //.excludePathPatterns("/api/**");
    }
}
