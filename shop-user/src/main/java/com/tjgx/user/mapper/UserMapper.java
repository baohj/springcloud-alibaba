package com.tjgx.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tjgx.user.entity.User;
import org.apache.ibatis.annotations.Mapper;


/**
*@Description:
*@Author: 鲍红建
*@date: 2020/12/28
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
