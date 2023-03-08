package com.stock.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author majj
 * @create 2022-11-23 20:59
 * 对于任意请求都能进行拦截处理
 * 全局Filter的pre处理优先于局部处理器的pre，全局Filter的post处理落后于局部处理器的post
 */
@Component
public class GlobalLogFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 前置过滤器
        System.out.println("GlobalLogFilter filtered!--PRE");
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                            // 后置过滤器
                            System.out.println("GlobalLogFilter filtered!--POST");
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