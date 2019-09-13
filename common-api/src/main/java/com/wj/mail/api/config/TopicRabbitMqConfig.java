package com.wj.mail.api.config;

import com.wj.mail.api.constant.QueueEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springLearnDemo <br>
 * @Description: Topic模式 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-28 11:12
 **/
@Configuration
public class TopicRabbitMqConfig {

    @Bean
    public Queue queueMessage() {
        return new Queue(QueueEnum.QUEUE_ORDER_TOPIC_MSG.getName());
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(QueueEnum.QUEUE_ORDER_TOPIC_MSG_MAPPING.getName());
    }

    /**
     * 声明一个Topic类型的交换机
     * @return
     */
    @Bean
    TopicExchange topicExchange() {
        return (TopicExchange) ExchangeBuilder
                .topicExchange(QueueEnum.QUEUE_ORDER_TOPIC_MSG.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 绑定Q到交换机,并且指定routingKey
     * @param queueMessage
     * @param topicExchange
     * @return
     */
    @Bean
    Binding bindingTopicExchangeMessage(Queue queueMessage, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueMessage).to(topicExchange).with(QueueEnum.QUEUE_ORDER_TOPIC_MSG.getRouteKey());
    }

    @Bean
    Binding bindingTopicExchangeMessages(Queue queueMessages, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueMessages).to(topicExchange).with(QueueEnum.QUEUE_ORDER_TOPIC_MSG_MAPPING.getRouteKey());
    }
}
