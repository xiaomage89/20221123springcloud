package com.stock.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.annotation.Annotation;

/**
 * @author majj
 * @create 2022-11-23 20:37
 */
public class MyGatewayFilter implements GatewayFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 前置过滤器
        System.out.println("LogFilter filtered!--PRE");
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                            // 后置过滤器
                            System.out.println("LogFilter filtered!--POST");
                        }
                ));
    }

    /**
     * 设定过滤器的优先级，值越小则优先级越高
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
