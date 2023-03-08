package com.stock.config;

import com.stock.filter.MyGatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author majj
 * @create 2022-11-23 20:41
 * Gateway使用自定义Filter
 */
@Configuration
public class MyGatewayConfig {

        @Bean
        public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
            return builder.routes()
                    .route("gateway1",r -> r.path("/user/**")
                            .filters(f -> f.filters(new MyGatewayFilter()))
                            .uri("lb://stock-service-1"))
                    .build();
        }
}
