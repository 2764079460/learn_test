package com.markerhub.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * Created by xiangmiao on 2020/7/10.
 */
@Component
public class JedisClient {

    @Autowired
    private JedisPool jedisPool;

    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String ss = jedis.get(key);
        jedis.close();
        return ss;
    }

    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String string = jedis.set(key, value);
        jedis.close();
        return string;
    }

    public Long del(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.del(key);
        jedis.close();
        return result;
    }

    public Set<String> keys(String key) {
        Jedis jedis = jedisPool.getResource();
        Set<String> res = jedis.keys(key);
        jedis.close();
        return res;
    }

}
