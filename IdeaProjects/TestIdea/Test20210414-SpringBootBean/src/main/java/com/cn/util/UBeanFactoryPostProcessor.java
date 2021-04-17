package com.cn.util;

import com.cn.bean.User;
import com.cn.bean.User1;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class UBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factoryBean) throws BeansException {

        GenericBeanDefinition bean = (GenericBeanDefinition)factoryBean.getBeanDefinition("helloBean");
        System.out.println(bean.getClass());
//        该接口可以需要修改bean对象
        bean.setBeanClass(User1.class);
//        Factory的后加载模式，新增bean
        factoryBean.registerSingleton("user", User.class);
    }
}
