package com.tjgx.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
*@Description:
*@Author: 鲍红建
*@date: 2020/12/31
*/
@SpringBootApplication
@EnableDiscoveryClient
public class GateWayStart {

    public static void main(String[] args) {
        SpringApplication.run(GateWayStart.class, args);
    }
}
