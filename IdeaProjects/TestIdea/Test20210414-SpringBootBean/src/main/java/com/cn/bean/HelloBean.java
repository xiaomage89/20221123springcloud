package com.cn.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloBean  implements BeanNameAware {

    @Autowired
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    取Bean名字
    private String beanName;

    @Override
    public void setBeanName(String s) {
        this.beanName=s;
    }

    public String getBeanName() {
        return beanName;
    }
}
