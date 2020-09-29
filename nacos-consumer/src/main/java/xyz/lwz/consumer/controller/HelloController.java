package xyz.lwz.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lwz.consumer.feign.HelloFeign;

import javax.annotation.Resource;

/**
 * @Author liwz
 * @Date 2020/9/29 10:37
 **/
@RestController
public class HelloController {
    @Resource
    HelloFeign helloFeign;

    @GetMapping(value = "hello")
    String hello(){
        return helloFeign.hello();
    }
}
