package com.wj.mail.api.config;

import com.wj.mail.api.component.TopicMessageConfirmSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @program: springLearnDemo <br>
 * @Description: 发送到交换机上失败回调 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-28 15:50
 **/
public class RabbitConfirmCallback implements RabbitTemplate.ConfirmCallback {
    private static Logger LOGGER = LoggerFactory.getLogger(RabbitConfirmCallback.class);
    /**
     * 发送到交换机上失败回调
     * 消息发送回调(判断是否发送到相应的交换机上)
     * @param correlationData   消息唯一标识
     * @param ack               消息确认结果
     * @param cause             失败原因
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            LOGGER.info("消息发送到exchange成功");
        } else {
            LOGGER.info("消息发送到exchange失败");
        }
    }
}
