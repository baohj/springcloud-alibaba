package com.tjgx.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.web.client.RestTemplate;

/**
*@Description:
*@Author: 鲍红建
*@date: 2020/12/28
*/
@SpringBootApplication(scanBasePackages = {"com.tjgx.*"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.tjgx.*"})
public class OrderStart {

    public static void main(String[] args) {
        SpringApplication.run(OrderStart.class, args);
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();

    }
}
