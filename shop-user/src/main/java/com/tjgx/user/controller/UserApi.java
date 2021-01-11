package com.tjgx.user.controller;

import com.tjgx.common.product.exception.Result;
import com.tjgx.common.product.vo.UserOut;
import com.tjgx.user.entity.User;
import com.tjgx.user.mapper.UserMapper;
import com.tjgx.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private UserService userService;

    @ApiOperation("获取用户")
    @PostMapping("/getUser")
    public Result<List<UserOut>> getUser(){
        try {
            Thread.sleep(3000);
        }catch (Exception e){

        }
        List<User> list = userMapper.selectList(null);
        List<UserOut> lt = list.stream().map(v -> {
            UserOut userOut = new UserOut();
            BeanUtils.copyProperties(v, userOut);
            return userOut;
        }).collect(Collectors.toList());
       return Result.success(lt);
    }

    @ApiOperation("新增用户")
    @PostMapping("/saveUser")
    public Result saveUser(){
        return userService.saveUser();
    }
}
