package com.wj.mail.api.service.impl;

import com.wj.mail.api.component.CancelOrderSender;
import com.wj.mail.api.service.CancelOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: springLearnDemo <br>
 * @Description: 取消订单服务类 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-20 17:11
 **/
@Service
public class CancelOrderServiceImpl implements CancelOrderService {
    private static Logger LOGGER = LoggerFactory.getLogger(CancelOrderServiceImpl.class);

    @Autowired
    private CancelOrderSender cancelOrderSender;
    /**
     * Description: <br>
     * @param orderId <br>
     * @author Wu.Jiang <br>
     * @date 2019/6/20 <br>
     */
    @Override
    public void cancelOrder(Long orderId) {
        LOGGER.info("cancel the order start ... orderId:{}",orderId);
        //TODO
        LOGGER.info("cancel the order end ... orderId:{}",orderId);

    }

    /**
     * Description: <br>
     * @param orderId
     * @author Wu.Jiang <br>
     * @date 2019/6/20 <br>
     */
    @Override
    public void sendDelayMessageCancelOrder(Long orderId) {
        //获取订单超时时间，假设为60分钟
        long delayTimes = 5 * 1000;
        //发送延迟消息
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }

    /**
     * Description: <br>
     * @param prodItem <br>
     * @author Wu.Jiang <br>
     * @date 2019/6/20 <br>
     */
    @Override
    public void createOrder(String prodItem) {
        LOGGER.info("createOrder the order start ...");
        sendDelayMessageCancelOrder(100L);
        LOGGER.info("createOrder the order end ...");
    }
}