package com.example.kafaka2.redis;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 2019/8/5
 * Time: 15:27
 */
public class Redis {

    private Jedis jedis;


    @Test
    public void test (){
        System.out.println(jedis.set("k1","v1"));
        System.out.println(jedis.get("k1"));
    }


    @Before
    public void getJedis (){
         jedis = new Jedis("172.16.0.107",8000);
    }
}
