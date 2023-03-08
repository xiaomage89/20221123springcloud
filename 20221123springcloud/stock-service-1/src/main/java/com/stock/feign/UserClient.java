package com.stock.feign;

import com.stock.configuration.FeignLogConfiguration;
import com.stock.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author majj
 * @create 2022-11-22 23:46
 * Feign会通过动态代理，帮我们生成实现类 Feign会根据注解帮我们生成URL，并访问获取结果
 */
@Component
@FeignClient(value = "stock-service-2", fallback = UserClientFallback.class, configuration = FeignLogConfiguration.class)
public interface UserClient {

    @GetMapping("user/queryUserById/{id}")
    User queryUserById(@PathVariable("id") Long id);

}
