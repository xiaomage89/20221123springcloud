package com.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //Feign中本身已经集成了Ribbon依赖和自动配置 Feign默认也有对Hystrix的集成(默认情况下是关闭的)
public class StockService1Application {

    public static void main(String[] args) {
        SpringApplication.run(StockService1Application.class, args);
    }

}
