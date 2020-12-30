package com.tjgx.user.controller;

import com.tjgx.user.entity.User;
import com.tjgx.user.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
*@Description:
*@Author: 鲍红建
*@date: 2020/12/28
*/
@RestController
@RequestMapping("/user")
@Slf4j
@Api(tags = "用户模块【鲍红建】")
public class UserApi {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation("获取用户")
    @PostMapping("/getUser")
    public List<User> getUser(){
        List<User> list = userMapper.selectList(null);
        return list;
    }
}
