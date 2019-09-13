package com.wj.mail.api.config;

import com.wj.mail.api.constant.QueueEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springLearnDemo <br>
 * @Description: Fanout订阅广播模式 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-28 11:12
 **/
@Configuration
public class FanoutRabbitMqConfig {

    @Bean
    public Queue fanoutQueueA() {
        return new Queue(QueueEnum.QUEUE_ORDER_FANOUT_MSG_A.getName());
    }

    @Bean
    public Queue fanoutQueueB() {
        return new Queue(QueueEnum.QUEUE_ORDER_FANOUT_MSG_B.getName());
    }

    /**
     * 声明一个Fanout类型的交换机
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange() {
        return (FanoutExchange) ExchangeBuilder
                .fanoutExchange(QueueEnum.QUEUE_ORDER_FANOUT_MSG_A.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 绑定Q到交换机
     * @param fanoutQueueA
     * @param fanoutExchange
     * @return
     */
    @Bean
    Binding bindingFanoutExchangeA(Queue fanoutQueueA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueA).to(fanoutExchange);
    }

    @Bean
    Binding bindingFanoutExchangeB(Queue fanoutQueueB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueB).to(fanoutExchange);
    }
}
