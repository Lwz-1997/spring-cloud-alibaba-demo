package xyz.lwz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import xyz.lwz.entity.User;
import xyz.lwz.feign.RedisFeign;
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

    @Resource
    private RedisFeign redisFeign;

    @GetMapping(value = "list")
    public List<User> getUsers() {
        List<User> users = userService.list();
        boolean isCache = redisFeign.setCache("list", users, -1);
        System.out.println(isCache);
        return users;
    }

    @GetMapping(value = "1")
    public Object getUser() {
        Object user = redisFeign.getCache("user");
        System.out.println(user);
        return user;
    }

    @GetMapping(value = "hello")
    String hello() {
        return "hello Nacos!";
    }

}
