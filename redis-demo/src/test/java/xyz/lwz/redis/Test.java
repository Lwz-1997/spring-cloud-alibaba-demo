package xyz.lwz.redis;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.lwz.redis.domain.User;
import xyz.lwz.redis.util.RedisUtils;

import javax.annotation.Resource;

/**
 * @Author liwz
 * @Date 2020/9/30 15:47
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Resource
    private RedisUtils redisUtils;

    /**
     * 执行前插入值
     */
    @Before
    public void setUp(){
        redisUtils.set("aaa", new User(1, "lwz"));
        System.out.println("插入值成功");
    }

    /**
     * 执行获取值
     */
    @org.junit.Test
    public void test(){
        System.out.println(redisUtils.get("aaa"));
    }
}
