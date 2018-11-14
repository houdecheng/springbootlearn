package com.hdc.springbootlearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hdc
 * @Date 2018/11/14 0014 14:24
 * @Version 1.0
 * @Description
 **/
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/say")
    public String say(String username){
        return "Hello,"+username;
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/save")
    public boolean testRedis(String value) throws Exception {

        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa",value);
        return true;
    }
}
