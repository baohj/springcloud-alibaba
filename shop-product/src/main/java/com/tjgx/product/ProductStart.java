package com.tjgx.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
*@Description:
*@Author: 鲍红建
*@date: 2020/12/29
*/
@SpringBootApplication
@EnableDiscoveryClient
public class ProductStart {

    public static void main(String[] args) {
        SpringApplication.run(ProductStart.class, args);
    }
}
