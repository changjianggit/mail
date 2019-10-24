package com.wj.mail.api.service.impl;

import com.wj.mail.api.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @program: springLearnDemo <br>
 * @Description: Redis操作实现类 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-25 11:11
 **/
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 存储数据
     *
     * @param key
     * @param value
     */
    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public boolean setIfAbsent(String key, String value) {
        return stringRedisTemplate.opsForValue().setIfAbsent(key, value);
    }

    @Override
    public String getAndSet(String key, String value) {
        return stringRedisTemplate.opsForValue().getAndSet(key, value);
    }

    /**
     * 获取数据
     *
     * @param key
     */
    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 设置超期时间
     *
     * @param key
     * @param expire
     */
    @Override
    public boolean expire(String key, long expire) {
        return stringRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    /**
     * 删除数据
     *
     * @param key
     */
    @Override
    public void remove(String key) {
        stringRedisTemplate.delete(key);
    }

    /**
     * 删除数据
     *
     * @param key
     */
    @Override
    public boolean removeWithResult(String key) {
        return stringRedisTemplate.delete(key);
    }

    /**
     * 自增操作
     *
     * @param key
     * @param delta 自增步长
     */
    @Override
    public Long increment(String key, long delta) {
        return stringRedisTemplate.opsForValue().increment(key,delta);
    }

    /**
     * Put Hash
     * @param targetMap 目标map
     */
    @Override
    public void setHash(String key, Map<String, Object> targetMap) {
        stringRedisTemplate.opsForHash().putAll(key, targetMap);
    }

    /**
     * Add a value in hash
     * @param key
     * @param mapKey
     * @param value
     */
    @Override
    public void addValueInHash(String key, String mapKey, Object value) {
        stringRedisTemplate.opsForHash().put(key, mapKey, value);

    }

    /**
     * Description: <br>
     * @param key
     * @param strings
     * @author Wu.Jiang <br>
     * @date 2019/6/25 <br>
     */
    @Override
    public void leftPushList(String key, String[] strings) {
        stringRedisTemplate.opsForList().leftPushAll(key, strings);
    }

    /**
     * Description: <br>
     * @param key
     * @param strings
     * @author Wu.Jiang <br>
     * @date 2019/6/25 <br>
     */
    @Override
    public void rightPushList(String key, String[] strings) {
        stringRedisTemplate.opsForList().rightPushAll(key, strings);
    }

    /**
     * Description: <br>
     * @param key
     * @param strings
     * @author Wu.Jiang <br>
     * @date 2019/6/25 <br>
     */
    @Override
    public void addSet(String key, String[] strings) {
        stringRedisTemplate.opsForSet().add(key, strings);
    }
}
