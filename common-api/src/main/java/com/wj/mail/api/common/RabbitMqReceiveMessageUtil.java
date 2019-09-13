package com.wj.mail.api.common;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;

import java.io.IOException;

/**
 * @program: springLearnDemo <br>
 * @Description: RabbitMq接收消息处理 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-28 16:52
 **/
public final class RabbitMqReceiveMessageUtil {
    private static Logger LOGGER = LoggerFactory.getLogger(RabbitMqReceiveMessageUtil.class);
    private RabbitMqReceiveMessageUtil() {
        // Forbidden to access
    }

    public static void receiverCommonHandler(String receiveMessage, Message message, Channel channel) {
        try {
            // 手动签收
            LOGGER.info("接收到消息:[{}]", receiveMessage);
//            if (new Random().nextInt(10) < 5) {
//                LOGGER.warn("拒绝一条信息:[{}]，此消息将会由死信交换器进行路由.", receiveMessage);
////                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
//            } else {
//
//            }
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        } catch (Exception e) {
            LOGGER.info("接收到消息之后的处理发生异常.", e);
            try {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
            } catch (IOException e1) {
                LOGGER.error("签收异常.", e1);
            }
        }
    }
}
