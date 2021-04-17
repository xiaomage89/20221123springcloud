package com.cn.service;

import com.cn.dao.OrderMapper;
import com.cn.dao.UserMapperT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestUserMapperBatch {

    @Autowired(required = false)
    private UserMapperT userMapperT;

    @Autowired(required = false)
    private OrderMapper orderMapper;

    public void getTest() {
        userMapperT.getSelect(1);
        orderMapper.getSelect(1);
    }
}
