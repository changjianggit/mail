package com.wj.mail.api.component;

import com.wj.mail.api.config.RabbitConfirmCallback;
import com.wj.mail.api.constant.QueueEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: springLearnDemo <br>
 * @Description: Topic消息发送类(生产者消息回调) <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-28 12:36
 **/
@Component
public class TopicMessageConfirmSender {

    private static Logger LOGGER = LoggerFactory.getLogger(TopicMessageConfirmSender.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void sendData(String content) {
        //监听回调函数
        //消息唯一ID
        CorrelationData correlationData = new CorrelationData("123456");

        rabbitTemplate.convertAndSend(QueueEnum.QUEUE_ORDER_TOPIC_MSG.getExchange(),
                QueueEnum.QUEUE_ORDER_TOPIC_MSG.getRouteKey(),
                content, 		//消息体内容
                correlationData);   //消息唯一ID
    }
}
