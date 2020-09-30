package xyz.lwz.redis.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author liwz
 * @Date 2020/9/30 16:40
 **/
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 6323049783596229416L;

    private int age;
    private String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
