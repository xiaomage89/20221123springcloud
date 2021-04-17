package com.cn.test;

import com.Application;
import com.cn.bean.HelloBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpringBean {
    public static void main(String[] args) {
        //bean 和 new 创建 对象区别
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        HelloBean helloBean = context.getBean("helloBean", HelloBean.class);
        HelloBean helloBean1 = new HelloBean();
        System.out.println(helloBean);
        System.out.println(helloBean1);
        System.out.println(helloBean.getUser());//user spring帮忙创建对象
        System.out.println(helloBean1.getUser()); //user  没有对象

        System.out.println(helloBean.getBeanName());//获取beanName   implements BeanNameAware类

    }
}
