package com.wj.mail.api.service;

import java.util.Map;

/**
 * redis操作Service,
 * 对象和数组都以json形式进行存储
 * Created by Wu.Jiang on 2019/06/25
 */
public interface RedisLockService {

    /**
     * Description:  获取分布式锁<br>
     *
     * @param key 唯一标识<br>
     * @param timeStamp 当前时间+超时时间<br>
     * @return boolean <br>
     * @author Wu.Jiang <br>
     * @date 2019/6/25 <br>
     */
    boolean lock(String key, String timeStamp);

    /**
     * Description: 释放锁<br>
     * @param key <br>
     * @param timeStamp <br>
     * @author Wu.Jiang <br>
     * @date 2019/6/25 <br>
     */
    void unLock(String key, String timeStamp);

}
