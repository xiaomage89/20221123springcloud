package com.cn.service;

import com.cn.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestUserMapper {

    @Autowired
    private UserMapper userMapper;

    public void getTest() {
        userMapper.getSelect(1);
    }
}
