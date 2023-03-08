package com.stock.stockservice.controller;

import com.stock.stockservice.pojo.User;
import com.stock.stockservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author majj
 * @create 2022-11-21 23:58
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("queryUserById/{id}")
    @ResponseBody
    public User queryUserById(@PathVariable("id") Long id) {
        User user =   this.userService.queryUserById(id);
        System.out.println("stock-service:8081============"+user.toString());
        //设置hystrix的超时时间为6000ms 请求在超过1秒后都会返回错误信息，这是因为Hystix的默认超时时长为1
        // try {
        //     Thread.sleep(1000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        return user;
    }
}
