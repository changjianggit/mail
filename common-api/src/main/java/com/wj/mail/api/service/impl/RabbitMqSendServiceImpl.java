package com.wj.mail.api.service.impl;

import com.wj.mail.api.component.FanoutMessageSender;
import com.wj.mail.api.component.TopicMessageConfirmSender;
import com.wj.mail.api.component.TopicMessageSender;
import com.wj.mail.api.service.RabbitMqSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: springLearnDemo <br>
 * @Description: RabbitMq消息发送类 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-28 12:12
 **/
@Service
public class RabbitMqSendServiceImpl implements RabbitMqSendService {
    @Autowired
    private TopicMessageSender topicMessageSender;

    @Autowired
    private TopicMessageConfirmSender topicMessageConfirmSender;

    @Autowired
    private FanoutMessageSender fanoutMessageSender;
    /**
     * Description: <br>
     *
     * @param sendContent <br>
     * @author Wu.Jiang <br>
     * @date 2019/6/28 <br>
     */
    @Override
    public void sendTopicMessage(String sendContent) {
        topicMessageSender.sendTopicMessage(sendContent);
    }

    /**
     * Description: <br>
     *
     * @param sendContent <br>
     * @author Wu.Jiang <br>
     * @date 2019/6/28 <br>
     */
    @Override
    public void sendTopicMessages(String sendContent) {
        topicMessageSender.sendTopicMessages(sendContent);
    }

    /**
     * Description: <br>
     *
     * @param sendContent <br>
     * @author Wu.Jiang <br>
     * @date 2019/6/28 <br>
     */
    @Override
    public void sendFanoutMessage(String sendContent) {
        fanoutMessageSender.sendFanoutMessage(sendContent);
    }

    /**
     * Description: <br>
     *
     * @param sendContent <br>
     * @author Wu.Jiang <br>
     * @date 2019/6/28 <br>
     */
    @Override
    public void sendTopicConfirmMessage(String sendContent) {
        topicMessageConfirmSender.sendData(sendContent);
    }
}
