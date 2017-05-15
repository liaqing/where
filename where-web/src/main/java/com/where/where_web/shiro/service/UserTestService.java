package com.where.where_web.shiro.service;

import com.where.where_web.shiro.entity.UserTest;

public interface UserTestService {
    int deleteByPrimaryKey(Integer id);

    int insert(UserTest record);

    int insertSelective(UserTest record);

    UserTest selectByPrimaryKey(Integer id);
    
    UserTest selectByName(String username);

    int updateByPrimaryKeySelective(UserTest record);

    int updateByPrimaryKey(UserTest record);
}