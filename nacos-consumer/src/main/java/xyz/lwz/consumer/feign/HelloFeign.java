package xyz.lwz.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import xyz.lwz.consumer.feign.fallback.HelloFeignFallback;

/**
 * @Author liwz
 * @Date 2020/9/29 10:28
 **/
@FeignClient(value = "nacos-provider", fallback = HelloFeignFallback.class)
public interface HelloFeign {

    /**
     * feign接口调用
     * @return String
     */
    @GetMapping(value = "hello")
    String hello();
}
