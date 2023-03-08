package com.stock.feign;

import com.stock.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @author majj
 * @create 2022-11-22 23:57
 * Feign默认也有对Hystrix的集成(默认情况下是关闭的)
 */
@Component
public class UserClientFallback implements UserClient {

    @Override
    public User queryUserById(Long id) {
        User user = new User();
        user.setUsername("服务器繁忙，请稍后再试！");
        return user;
    }
}
