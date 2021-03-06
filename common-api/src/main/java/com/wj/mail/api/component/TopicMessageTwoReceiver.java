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

/**
 * @program: springLearnDemo <br>
 * @Description: mall.order.topic.queue2队列的消费者 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-28 11:50
 **/
@Component
@RabbitListener(queues = "mall.order.topic.queue2")
public class TopicMessageTwoReceiver {
    private static Logger LOGGER = LoggerFactory.getLogger(TopicMessageTwoReceiver.class);
    @RabbitHandler
    public void receiveMessage(String receiveMessage, Message message, Channel channel) {
        LOGGER.info("TopicMessageTwoReceiver receiveMessage begin{}", receiveMessage);
        RabbitMqReceiveMessageUtil.receiverCommonHandler(receiveMessage, message, channel);
        LOGGER.info("TopicMessageTwoReceiver receiveMessage end{}", receiveMessage);
    }
//    public void handle(String content){
//        LOGGER.info("TopicMessageTwoReceiver content:{}",content);
//    }
}
