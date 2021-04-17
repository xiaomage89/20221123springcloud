package com.cn.test;

import com.Application;
import com.cn.bean.User1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBeanFactoryPostProcessor {
    public static void main(String[] args) {
        //bean 和 new 创建 对象区别
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        /**
         * Exception in thread "main" org.springframework.beans.factory.BeanNotOfRequiredTypeException: Bean named 'helloBean' is expected to be of type 'com.cn.bean.HelloBean' but was actually of type 'com.cn.bean.User1'
         */
        //context.getBean("helloBean",HelloBean.class);

        /**
         * Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'user1' available
         */
//        User1 bean = context.getBean("user1", User1.class);
        User1 bean = context.getBean("helloBean", User1.class);
        System.out.println(bean);




    }
}
