package com.sweet.redis.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-*.xml"})
public class RedisCacleTest {

    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void testStrigCache(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("name","beijing",5,TimeUnit.SECONDS);
        valueOperations.setIfAbsent("city","shanghai",10,TimeUnit.SECONDS);//已经存在的key,不在赋值
        valueOperations.setIfPresent("sex","man",10,TimeUnit.SECONDS);
        valueOperations.set("sort",20);
        valueOperations.decrement("sort",2);
        Integer result = (Integer) valueOperations.get("sort");
        valueOperations.increment("sort",5);
        Integer integer = (Integer) valueOperations.get("sort");
        String value = (String) valueOperations.get("name");

    }
}
