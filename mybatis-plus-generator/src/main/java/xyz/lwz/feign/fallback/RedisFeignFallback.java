package xyz.lwz.feign.fallback;

import org.springframework.stereotype.Component;
import xyz.lwz.feign.RedisFeign;

/**
 * @Author liwz
 * @Date 2020/10/16 14:10
 **/
@Component
public class RedisFeignFallback implements RedisFeign {

    @Override
    public boolean setCache(String key, Object value, long time) {
        return false;
    }

    @Override
    public Object getCache(String key) {
        return null;
    }
}
