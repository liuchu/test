package me.liuchu.test.comm.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Redis示例
 */

public class TestRedis {

    /*@Autowired
    private JedisPool jedisPool;

    private void init(){

    }

    public void stringTest(){
        Jedis jedis = jedisPool.getResource();
        jedis.select(0);
        jedis.set("name", "liuchu");

        String name = jedis.get("name");
        System.out.println("key: name"+", value:"+name);
    }

    public void hashTest(){
        Jedis jedis = jedisPool.getResource();
        jedis.select(0);
    }*/
}
