package xyz.lwz.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import xyz.lwz.entity.User;
import xyz.lwz.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author liwz
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping(value = "list")
    public List<User> getUsers() {
        return userService.list();
    }

    @GetMapping(value = "hello")
    String hello() {
        return "hello Nacos!";
    }

}
