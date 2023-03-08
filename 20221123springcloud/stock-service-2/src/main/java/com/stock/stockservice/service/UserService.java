package com.stock.stockservice.service;

import com.stock.stockservice.mapper.UserMapper;
import com.stock.stockservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author majj
 * @create 2022-11-21 23:44
 */
@Service
public class UserService {

    /**
     * 由于我们使用的是Mapper组件，然后用的是import tk.mybatis.spring.annotation.MapperScan; 去扫描的包，而并没有向容器放入usermapper，所以我们这里就报错了
     * 添加 (required = false)
     */
    @Autowired(required = false)
    public UserMapper userMapper;

    public User queryUserById(Long id ){
        return  this.userMapper.selectByPrimaryKey(id);
    }
}
