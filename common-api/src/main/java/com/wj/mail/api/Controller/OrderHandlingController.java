package com.wj.mail.api.Controller;

import com.wj.mail.api.common.CommonResult;
import com.wj.mail.api.domin.OrderParam;
import com.wj.mail.api.service.HandlingOrderService;
import com.wj.mail.api.service.RedisLockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: springLearnDemo <br>
 * @Description: 订单处理Controller <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-20 14:45
 **/
@Api(tags = "OrderHandlingController", description = "订单处理类")
@Controller
@RequestMapping("/Order")
public class OrderHandlingController {

    @Autowired
    private HandlingOrderService handlingOrderService;

    @Autowired
    private RedisLockService redisLockService;

    private static final int KILL_TIME_OUT = 5*1000;

    @ApiOperation("生成商品订单")
    @RequestMapping(value = "/generateOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object generateOrder(@RequestBody OrderParam orderParam){
        return handlingOrderService.generateOrder(orderParam);
    }

    @ApiOperation("秒杀商品")
    @RequestMapping(value = "/killOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object killOrder(@RequestBody OrderParam orderParam){
        long timeStamp = System.currentTimeMillis() + KILL_TIME_OUT;
        String targetId = orderParam.getCouponId().toString();
        // 尝试获取锁
        if (!redisLockService.lock(targetId, String.valueOf(timeStamp))) {
            return CommonResult.failed("秒杀的人太多，请稍后再试");
        }
        try {
            // 模拟业务处理过程
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 释放锁(只有获取到锁的请求才会有释放锁的操作)
        redisLockService.unLock(targetId, String.valueOf(timeStamp));

        return CommonResult.success("恭喜你--秒杀成功");
    }

}
