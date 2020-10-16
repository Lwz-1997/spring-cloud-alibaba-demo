package xyz.lwz.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.lwz.feign.fallback.RedisFeignFallback;

/**
 * @Author liwz
 * @Date 2020/10/16 14:04
 **/
@FeignClient(value = "redis-cache", fallback = RedisFeignFallback.class)
public interface RedisFeign {

    /**
     * feign远程调用RedisCache
     *
     * @param key   key
     * @param value value
     * @param time  time 单位秒
     * @return 结果
     */
    @PostMapping("cache/set")
    boolean setCache(@RequestParam("key") String key, @RequestBody Object value, @RequestParam("time") long time);

    @GetMapping("cache/get")
    Object getCache(@RequestParam("key") String key);
}
