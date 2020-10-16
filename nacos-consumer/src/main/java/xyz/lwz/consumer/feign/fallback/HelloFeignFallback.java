package xyz.lwz.consumer.feign.fallback;

import org.springframework.stereotype.Component;
import xyz.lwz.consumer.feign.HelloFeign;

/**
 * @Author liwz
 * @Date 2020/9/29 10:28
 **/
@Component
public class HelloFeignFallback implements HelloFeign {
    @Override
    public String hello(String text) {
        return "feign调用失败";
    }
}
