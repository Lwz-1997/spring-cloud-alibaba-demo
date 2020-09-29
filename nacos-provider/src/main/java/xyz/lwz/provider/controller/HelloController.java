package xyz.lwz.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liwz
 * @Date 2020/9/29 9:05
 **/
@RestController
public class HelloController {

    @GetMapping(value = "hello")
    String hello() {
        return "hello Nacos!";
    }
}
