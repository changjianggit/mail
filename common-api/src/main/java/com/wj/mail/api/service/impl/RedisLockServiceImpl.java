package com.wj.mail.api.service.impl;

import com.wj.mail.api.service.RedisLockService;
import com.wj.mail.api.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @program: springLearnDemo <br>
 * @Description: Redis分布式锁获取 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-25 15:35
 **/
@Service
public class RedisLockServiceImpl implements RedisLockService {

    private static Logger LOGGER = LoggerFactory.getLogger(RedisLockServiceImpl.class);

    @Autowired
    private RedisService redisService;

    /**
     * Description:  获取分布式锁<br>
     *
     * @param key 唯一标识<br>
     * @param timeStamp 当前时间+超时时间<br>
     * @return boolean <br>
     * @author Wu.Jiang <br>
     * @date 2019/6/25 <br>
     */
    @Override
    public boolean lock(String key, String timeStamp) {
        LOGGER.info("get the lock key {} begin ...", key);
        // Redis setnx命令
        if (redisService.setIfAbsent(key, timeStamp)) {
            return true;
        }
        String currentLockTimeStamp = redisService.get(key);
        if (!StringUtils.isEmpty(currentLockTimeStamp) && Long.parseLong(currentLockTimeStamp) < System.currentTimeMillis()) {
            String preLock = redisService.getAndSet(key, timeStamp);
            if (!StringUtils.isEmpty(preLock) && preLock.equals(currentLockTimeStamp)) {
                return true;
            }
        }
        LOGGER.info("get the lock key {} end ...", key);
        return false;
    }

    /**
     * Description: 释放锁<br>
     * @param key <br>
     * @param timeStamp <br>
     * @author Wu.Jiang <br>
     * @date 2019/6/25 <br>
     */
    @Override
    public void unLock(String key, String timeStamp) {
        LOGGER.info("unLock the lock key {} begin ...", key);
        try {
            String currentLockTime = redisService.get(key);
            if (!StringUtils.isEmpty(currentLockTime) && currentLockTime.equals(timeStamp)) {
                redisService.remove(key);
            }
        } catch (Exception e) {
            LOGGER.error("unLock key{} error", key, e);
        }
        LOGGER.info("unLock the lock key {} end ...", key);
    }
}
