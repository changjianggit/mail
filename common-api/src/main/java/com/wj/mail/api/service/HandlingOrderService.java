package com.wj.mail.api.service;

import com.wj.mail.api.common.CommonResult;
import com.wj.mail.api.domin.OrderParam;

/**
 * @program: springLearnDemo <br>
 * @Description: 订单接口类 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-20 17:12
 **/
public interface HandlingOrderService {
    /**
     * Description: <br>
     * @param orderId <br>
     * @author Wu.Jiang <br>
     * @date 2019/6/20 <br>
     */
    CommonResult generateOrder(OrderParam orderParam);


}
