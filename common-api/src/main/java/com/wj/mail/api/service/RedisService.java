package com.wj.mail.api.service;

import java.util.Map;

/**
 * redis操作Service,
 * 对象和数组都以json形式进行存储
 * Created by Wu.Jiang on 2019/06/25
 */
public interface RedisService {
    /**
     * 存储数据
     */
    void set(String key, String value);

    /**
     * 如果key不存在则插入，存在则不处理
     */
    boolean setIfAbsent(String key, String value);

    /**
     * 对key设置value这个值，并且返回key原来的旧值
     */
    String getAndSet(String key, String value);

    /**
     * 获取数据
     */
    String get(String key);

    /**
     * 设置超期时间
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     */
    void remove(String key);

    /**
     * 自增操作
     * @param delta 自增步长
     */
    Long increment(String key, long delta);

    /**
     * Put Hash
     * @param key
     * @param targetMap 目标map
     */
    void setHash(String key, Map<String, Object> targetMap);

    /**
     * Add a value in hash
     * @param key
     * @param mapKey
     * @param value
     */
    void addValueInHash(String key, String mapKey, Object value);
    
    /**
     * Description: <br>
     * @param key
     * @param strings
     * @author Wu.Jiang <br>
     * @date 2019/6/25 <br>
     */
    void leftPushList(String key, String[] strings);

    /**
     * Description: <br>
     * @param key
     * @param strings
     * @author Wu.Jiang <br>
     * @date 2019/6/25 <br>
     */
    void rightPushList(String key, String[] strings);

    /**
     * Description: <br>
     * @param key
     * @param strings
     * @author Wu.Jiang <br>
     * @date 2019/6/25 <br>
     */
    void addSet(String key, String[] strings);

}
