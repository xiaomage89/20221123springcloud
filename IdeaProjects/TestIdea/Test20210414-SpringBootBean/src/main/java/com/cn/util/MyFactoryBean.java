package com.cn.util;

import com.cn.dao.UserMapper;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理对象方法
 */
@Component
public class MyFactoryBean  implements FactoryBean {

    @Override
    public Object getObject() throws Exception {

//      二 动态代理（没有具体的类名， 如何实现加载)   TestUserMapper
        UserMapper o = (UserMapper)Proxy.newProxyInstance(MyFactoryBean.class.getClassLoader(), new Class[]{UserMapper.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
        return o;
    }

    @Override
    public Class<?> getObjectType() {
        return UserMapper.class;
    }
}
