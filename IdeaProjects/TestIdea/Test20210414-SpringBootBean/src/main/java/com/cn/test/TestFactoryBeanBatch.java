package com.cn.test;

import com.Application;
import com.cn.service.TestUserMapperBatch;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestFactoryBeanBatch {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        TestUserMapperBatch testUserMapperBatch = (TestUserMapperBatch)context.getBean("testUserMapperBatch");
        testUserMapperBatch.getTest();
        System.out.println(testUserMapperBatch);
    }
}
