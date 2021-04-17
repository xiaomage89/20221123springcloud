package com.cn.util;

import com.cn.dao.UserMapper;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理对象方法
 */

public class MyFactoryBeanBatch implements FactoryBean {

    private Class mapper;

    public MyFactoryBeanBatch(Class mapper) {
        this.mapper = mapper;
    }

    @Override
    public Object getObject() throws Exception {
        //        三 批量动态代理
        Object o = Proxy.newProxyInstance(MyFactoryBeanBatch.class.getClassLoader(), new Class[]{mapper}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
        return o;
    }

    @Override
    public Class<?> getObjectType() {
        return mapper;
    }
}
