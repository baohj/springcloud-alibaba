package com.tjgx.user;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
*@Description:
*@Author: 鲍红建
*@date: 2020/12/28
*/
@SpringBootApplication(scanBasePackages = {"com.tjgx.*"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.tjgx.*"})
public class UserStart {
    public static void main(String[] args) {
        SpringApplication.run(UserStart.class, args);
    }
}
