package com.wj.mail.api.service;

/**
 * @program: springLearnDemo <br>
 * @Description: 取消订单接口类 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-20 17:12
 **/
public interface CancelOrderService {
    /**
     * Description: <br>
     * @param orderId <br>
     * @author Wu.Jiang <br>
     * @date 2019/6/20 <br>
     */
    void cancelOrder(Long orderId);

    /**
     * Description: <br>
     * @param orderId <br>
     * @author Wu.Jiang <br>
     * @date 2019/6/20 <br>
     */
    void sendDelayMessageCancelOrder(Long orderId);

    /**
     * Description: <br>
     * @param prodItem <br>
     * @author Wu.Jiang <br>
     * @date 2019/6/20 <br>
     */
    void createOrder(String prodItem);
}
