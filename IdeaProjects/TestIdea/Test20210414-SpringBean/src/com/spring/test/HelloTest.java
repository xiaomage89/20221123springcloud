package com.spring.test;

import com.spring.bean.TestHello;

public class HelloTest {

    public static void main(String[] args) {
        TestHello helloChinese =new TestHello("中文","你好");
        TestHello helloEnglish =new TestHello();
        helloEnglish.setId("英语");
        helloEnglish.setName("hello");
        System.out.println("普通的java程序:");
        System.out.println(helloEnglish.getId()+":"+helloEnglish.getName());
        System.out.println(helloChinese.getId()+":"+helloChinese.getName());
    }
}
