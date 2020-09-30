package xyz.lwz.provider.service;

import org.apache.dubbo.config.annotation.DubboService;
import xyz.lwz.provider.api.HelloApi;

/**
 * @Author liwz
 * @Date 2020/9/30 10:28
 **/
@DubboService(version = "1.0.0")
public class HelloProvider implements HelloApi {
    @Override
    public String hello() {
        return "你好啊";
    }
}
