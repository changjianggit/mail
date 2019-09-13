package com.wj.mail.api.service;

import com.wj.mail.api.common.CommonResult;
import com.wj.mail.api.domin.OrderParam;

/**
 * @program: springLearnDemo <br>
 * @Description: RabbitSend接口类 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-28 12:12
 **/
public interface RabbitMqSendService {
    /**
     * Description: <br>
     * @param sendContent <br>
     * @author Wu.Jiang <br>
     * @date 2019/6/28 <br>
     */
    void sendTopicMessage(String sendContent);

    /**
     * Description: <br>
     * @param sendContent <br>
     * @author Wu.Jiang <br>
     * @date 2019/6/28 <br>
     */
    void sendTopicMessages(String sendContent);

    /**
     * Description: <br>
     * @param sendContent <br>
     * @author Wu.Jiang <br>
     * @date 2019/6/28 <br>
     */
    void sendFanoutMessage(String sendContent);

    /**
     * Description: <br>
     * @param sendContent <br>
     * @author Wu.Jiang <br>
     * @date 2019/6/28 <br>
     */
    void sendTopicConfirmMessage(String sendContent);


}
