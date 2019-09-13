package com.wj.mail.api.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @program: springLearnDemo <br>
 * @Description: 消息失败后回调 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-28 15:52
 **/
public class RabbitReturnCallback implements RabbitTemplate.ReturnCallback {

    private static Logger LOGGER = LoggerFactory.getLogger(RabbitReturnCallback.class);
    /**
     * 发送到队列失败后回调
     * 消息可以发送到相应交换机，但是没有相应路由键和队列绑定
     * @param message   返回消息
     * @param i         返回状态码
     * @param s         回复文本
     * @param s1        交换机
     * @param s2        路由键
     */
    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        LOGGER.info("消息发送失败");
    }
}
