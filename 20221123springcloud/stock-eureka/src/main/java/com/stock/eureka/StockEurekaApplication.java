package com.stock.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer   //http://127.0.0.1:10086/
public class StockEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockEurekaApplication.class, args);
    }

}
