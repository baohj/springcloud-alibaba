package com.tjgx.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
*@Description:
*@Author: 鲍红建
*@date: 2020/12/28
*/
@SpringBootApplication
@EnableDiscoveryClient
public class UserStart {

    public static void main(String[] args) {
        SpringApplication.run(UserStart.class, args);
    }
}
