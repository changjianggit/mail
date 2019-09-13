package com.wj.mail.api.component;

import com.wj.mail.api.constant.QueueEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: springLearnDemo <br>
 * @Description: Fanout消息发送类 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-28 12:36
 **/
@Component
public class FanoutMessageSender {

    private static Logger LOGGER = LoggerFactory.getLogger(FanoutMessageSender.class);
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendFanoutMessage(String sendContent){
        LOGGER.info("sendFanoutMessage begin:{}", sendContent);
        //给Fanout模式队列发送消息
        amqpTemplate.convertAndSend(QueueEnum.QUEUE_ORDER_FANOUT_MSG_A.getExchange(), "", sendContent);
        LOGGER.info("sendFanoutMessage end:{}", sendContent);
    }

}
