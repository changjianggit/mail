package com.wj.mail.api.component;

import com.rabbitmq.client.Channel;
import com.wj.mail.api.common.RabbitMqReceiveMessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Random;

/**
 * @program: springLearnDemo <br>
 * @Description: mall.order.topic.queue1队列的消费者 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-28 11:50
 **/
@Component
@RabbitListener(queues = "mall.order.topic.queue1")
public class TopicMessageConfirmReceiver {
    private static Logger LOGGER = LoggerFactory.getLogger(TopicMessageConfirmReceiver.class);
    @RabbitHandler
    public void receiveMessage(String receiveMessage, Message message, Channel channel) {
        LOGGER.info("TopicMessageConfirmReceiver receiveMessage begin{}", receiveMessage);
        RabbitMqReceiveMessageUtil.receiverCommonHandler(receiveMessage, message, channel);
        LOGGER.info("TopicMessageConfirmReceiver receiveMessage end{}", receiveMessage);
    }
}
