package com.stock.controller;

import com.stock.feign.UserClient;
import com.stock.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author majj
 * @create 2022-11-22 10:49
 */
@Controller
@RequestMapping("user")   //http://localhost/user/queryUserById/?id=1
public class UserController {

    @Autowired
    private UserClient userClient;

    @GetMapping("queryUserById")
    @ResponseBody
    public User queryUserById(@RequestParam(name = "id") Long id) {

        User user = this.userClient.queryUserById(id);

        System.out.println("stock-service-1:8080"+user.toString());
        return user;

    }


}
