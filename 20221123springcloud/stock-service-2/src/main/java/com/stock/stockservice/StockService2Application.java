package com.stock.stockservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.stock.stockservice.mapper")//Mapper 接口的包扫描
@EnableDiscoveryClient
public class StockService2Application {

    public static void main(String[] args) {
        SpringApplication.run(StockService2Application.class, args);
    }

}
