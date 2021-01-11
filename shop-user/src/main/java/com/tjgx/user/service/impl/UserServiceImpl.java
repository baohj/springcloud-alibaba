package com.tjgx.user.service.impl;

import com.tjgx.common.product.exception.Result;
import com.tjgx.user.entity.User;
import com.tjgx.user.mapper.UserMapper;
import com.tjgx.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public Result saveUser(){
        User user = new User();
        user.setUserId(100);
        user.setUserName("鲍红建");
        user.setTelephone("18310536874");
        user.setPassword("123456");
        userMapper.insert(user);
        int i =0;
        int f = 5 / i;
        return Result.Ok;
    }
}
