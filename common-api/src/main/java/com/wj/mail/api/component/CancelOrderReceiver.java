package com.wj.mail.api.component;

import com.wj.mail.api.service.CancelOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: springLearnDemo <br>
 * @Description: 取消订单接收类 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-20 17:08
 **/
@Component
@RabbitListener(queues = "mall.order.cancel")
public class CancelOrderReceiver {
    private static Logger LOGGER = LoggerFactory.getLogger(CancelOrderReceiver.class);
    @Autowired
    private CancelOrderService cancelOrderService;
    @RabbitHandler
    public void handle(Long orderId){
        LOGGER.info("receive delay message orderId:{}",orderId);
        cancelOrderService.cancelOrder(orderId);
    }
}
