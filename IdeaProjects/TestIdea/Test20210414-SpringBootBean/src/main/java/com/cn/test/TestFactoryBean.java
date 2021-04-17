package com.cn.test;

import com.Application;
import com.cn.service.TestUserMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestFactoryBean {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
//        方法错误的bean对象名称错误 代理模式
//        System.out.println(context.getBean("user2"));
        System.out.println(context.getBean("myFactoryBean"));
        System.out.println(context.getBean("myFactoryBean"));

//        动态代理（没有具体的类名， 不能实现加载)
//        System.out.println(context.getBean("userMapper"));
//        System.out.println(context.getBean("myFactoryBean"));
        TestUserMapper testUserMapper = (TestUserMapper)context.getBean("testUserMapper");
        testUserMapper.getTest();
        System.out.println(testUserMapper);
    }
}
