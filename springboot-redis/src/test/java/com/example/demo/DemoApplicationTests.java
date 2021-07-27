package com.example.demo;

import com.example.demo.pojo.User;
import com.example.demo.utils.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;
    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("mykey","xqxq");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
    }

    @Test
    public void  test() throws JsonProcessingException {
        User user = new User("xq",12);
//        String json = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user", user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

    @Test
    public void test1(){
        redisUtil.set("0","9");

    }
}
