package com.wj.mail.api.component;

import com.wj.mail.api.constant.QueueEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: springLearnDemo <br>
 * @Description: Topic消息发送类 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-28 12:36
 **/
@Component
public class TopicMessageSender {

    private static Logger LOGGER = LoggerFactory.getLogger(TopicMessageSender.class);
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendTopicMessage(String sendContent){
        LOGGER.info("sendTopicMessage begin:{}", sendContent);
        //给Topic模式队列发送消息
        amqpTemplate.convertAndSend(QueueEnum.QUEUE_ORDER_TOPIC_MSG.getExchange(), QueueEnum.QUEUE_ORDER_TOPIC_MSG.getRouteKey(), sendContent);
        LOGGER.info("sendTopicMessage end:{}", sendContent);
    }

    public void sendTopicMessages(String sendContent){
        LOGGER.info("sendTopicMessages begin:{}", sendContent);
        //给Topic模式队列发送消息匹配
        amqpTemplate.convertAndSend(QueueEnum.QUEUE_ORDER_TOPIC_MSG_MU.getExchange(), QueueEnum.QUEUE_ORDER_TOPIC_MSG_MU.getRouteKey(), sendContent);
        LOGGER.info("sendTopicMessages end:{}", sendContent);
    }
}
