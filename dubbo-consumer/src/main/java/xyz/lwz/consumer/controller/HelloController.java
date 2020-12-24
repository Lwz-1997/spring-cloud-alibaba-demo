package xyz.lwz.consumer.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lwz.provider.api.HelloApi;

/**
 * @Author liwz
 * @Date 2020/9/30 11:39
 **/
@RestController
public class HelloController {

    @DubboReference(version = "1.0.0")
    HelloApi helloApi;

    @GetMapping(value = "/hello")
    public String hello(){
        return helloApi.hello();
    }
}
