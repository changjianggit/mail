package com.wj.mail.api.Controller;

import com.wj.mail.api.common.CommonResult;
import com.wj.mail.api.service.RabbitMqSendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: springLearnDemo <br>
 * @Description: RabbitMqSendController <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-28 12:25
 **/
@Api(tags = "RabbitMqSendController", description = "RabbitMQ操作类")
@Controller
@RequestMapping("/rabbit")
public class RabbitMqSendController {
    @Autowired
    private RabbitMqSendService rabbitMqSendService;

    @ApiOperation("发送Topic消息.模糊匹配+唯一队列")
    @RequestMapping(value = "/sendTopicMessage", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> sendTopicMessage() {
        rabbitMqSendService.sendTopicMessage("TEST1");
        return CommonResult.success("发送成功匹配多个消息者");
    }

    @ApiOperation("发送Topic消息.模糊匹配")
    @RequestMapping(value = "/sendTopicMessages", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> sendTopicMessages() {
        rabbitMqSendService.sendTopicMessages("TEST2");
        return CommonResult.success("发送成功，只有一个消费者消费");
    }

    @ApiOperation("发送Fanout消息")
    @RequestMapping(value = "/sendFanoutMessage", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> sendFanoutMessage() {
        rabbitMqSendService.sendFanoutMessage("Test Fanout");
        return CommonResult.success("发送成功，所有订阅了的消费者都能拿到这条消息");
    }

    @ApiOperation("发送Topic Confirm消息")
    @RequestMapping(value = "/sendTopicConfirmMessage", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> sendTopicConfirmMessage() {
        rabbitMqSendService.sendTopicConfirmMessage("Test Confirm");
        return CommonResult.success("发送成功，所有订阅了的消费者都能拿到这条消息");
    }

}
