package com.cn.util;

import com.cn.dao.OrderMapper;
import com.cn.dao.UserMapperT;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
//        引用自定义Scan
        Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(MyScan.class.getName());
        Object o = attributes.get("value");
        List<Class> mappers = new ArrayList<Class>();
        String path = Thread.currentThread().getContextClassLoader().getResource(o.toString().replace(".","/")).getPath();
        File file = new File(path);
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.getName().equals("UserMapper.class")) continue;
            String name = o.toString() + "."+ file1.getName().replace(".class","");
            try {
                Class<?> aClass = Class.forName(name);
                mappers.add(aClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        for (Class mapper : mappers) {
            BeanDefinitionBuilder beanDefinition = BeanDefinitionBuilder.genericBeanDefinition();
            AbstractBeanDefinition definition = beanDefinition.getBeanDefinition();
            definition.setBeanClass(MyFactoryBeanBatch.class);
            definition.getConstructorArgumentValues().addGenericArgumentValue(mapper);

            registry.registerBeanDefinition(mapper.getSimpleName(),definition);
        }
    }
}
