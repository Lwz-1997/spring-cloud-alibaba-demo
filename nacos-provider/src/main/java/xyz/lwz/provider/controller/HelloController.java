package xyz.lwz.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liwz
 * @Date 2020/9/29 9:05
 **/
@RestController
@RequestMapping("nacos")
public class HelloController {

    @GetMapping("hello")
    public String hello(String text) {
        return text;
    }
}
