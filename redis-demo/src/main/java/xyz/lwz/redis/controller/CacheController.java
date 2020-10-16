package xyz.lwz.redis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lwz.redis.domain.User;
import xyz.lwz.redis.util.RedisUtils;

import javax.annotation.Resource;

/**
 * @Author liwz
 * @Date 2020/10/15 9:59
 **/
@RestController
@RequestMapping("cache")
public class CacheController {

    @Resource
    private RedisUtils redisUtils;

    @PostMapping("set")
    public boolean setCache(String key, Object value, long time) {
//        value=new User(12,"lily");
        return redisUtils.set(key, value, time);
    }

    @GetMapping("get")
    public Object getCache(String key) {
        return redisUtils.get(key);
    }
}
