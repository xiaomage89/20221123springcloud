package com;

import com.cn.util.MyImportBeanDefinitionRegistrar;
import com.cn.util.MyScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan("com.cn")
@MyScan("com.cn.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
}
