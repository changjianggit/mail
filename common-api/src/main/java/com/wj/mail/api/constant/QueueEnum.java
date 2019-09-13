package com.wj.mail.api.constant;

import lombok.Getter;

/**
 * @program: springLearnDemo <br>
 * @Description: RabbitMQ常量类 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-20 16:20
 **/
@Getter
public enum QueueEnum {
    /**
     * 消息通知队列
     */
    QUEUE_ORDER_CANCEL("mall.order.direct", "mall.order.cancel", "mall.order.cancel"),

    /**
     * 消息通知ttl队列
     */
    QUEUE_TTL_ORDER_CANCEL("mall.order.direct.ttl", "mall.order.cancel.ttl", "mall.order.cancel.ttl"),

    /**
     * 消息通知TOPIC队列(严格匹配)
     */
    QUEUE_ORDER_TOPIC_MSG("mall.order.topic", "mall.order.topic.queue1", "topic.message"),

    /**
     * 消息通知TOPIC队列(模糊匹配)
     */
    QUEUE_ORDER_TOPIC_MSG_MAPPING("mall.order.topic", "mall.order.topic.queue2", "topic.#"),

    /**
     * 消息通知TOPIC队列
     */
    QUEUE_ORDER_TOPIC_MSG_MU("mall.order.topic", "mall.order.topic.queue2", "topic.messages"),

    /**
     * 消息通知FANOUT_A队列
     */
    QUEUE_ORDER_FANOUT_MSG_A("mall.order.fanout", "mall.order.fanout.queueA", ""),

    /**
     * 消息通知FANOUT_B队列
     */
    QUEUE_ORDER_FANOUT_MSG_B("mall.order.fanout", "mall.order.fanout.queueB", "");

    /**
     * 交换名称
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 路由键
     */
    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}
