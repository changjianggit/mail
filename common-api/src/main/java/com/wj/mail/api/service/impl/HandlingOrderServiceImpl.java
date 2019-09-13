package com.wj.mail.api.service.impl;

import com.wj.mail.api.common.CommonResult;
import com.wj.mail.api.domin.OrderParam;
import com.wj.mail.api.service.HandlingOrderService;
import com.wj.mail.api.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: springLearnDemo <br>
 * @Description: 订单处理实现类 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-25 11:27
 **/
@Service
public class HandlingOrderServiceImpl implements HandlingOrderService {
    private static Logger LOGGER = LoggerFactory.getLogger(HandlingOrderServiceImpl.class);

    @Autowired
    private RedisService redisService;

    /**
     * Description: <br>
     *
     * @param orderParam <br>
     * @author Wu.Jiang <br>
     * @date 2019/6/20 <br>
     */
    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
        LOGGER.info("generateOrder start ... orderId:{}",orderParam.getMemberReceiveAddressId());
        String orderId = generateOrderSn();
        //TODO
        LOGGER.info("generateOrderSn orderId:{}", orderId);
        Map<String, Object> targetMap = new HashMap<>();
        targetMap.put("TEST1", "test1");
        redisService.setHash("HASH_KEY", targetMap);
        redisService.addValueInHash("HASH_KEY", "TEST2", "test2");
        String[] strings = {"1", "2", "3", "4"};
        redisService.leftPushList("LEFT_LIST_KEY", strings);
        redisService.rightPushList("RIGHT_LIST_KEY", strings);
        redisService.addSet("SET_KEY", strings);
        Map<String, Object> result = new HashMap<>();
        result.put("order", orderParam);
        return CommonResult.success(result, "下单成功");
    }

    /**
     * 生成18位订单编号:8位日期+2位平台号码+2位支付方式+6位以上自增id
     */
    private String generateOrderSn() {
        StringBuilder sb = new StringBuilder();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        StringBuilder sbKey = new StringBuilder();
        sbKey.append("ORDER_ID_KEY").append(date);
        Long increment = redisService.increment(sbKey.toString(), 1);
        sb.append(date);
        sb.append(String.format("%02d", 1L));
        sb.append(String.format("%02d", 2L));
        String incrementStr = increment.toString();
        if (incrementStr.length() <= 6) {
            sb.append(String.format("%06d", increment));
        } else {
            sb.append(incrementStr);
        }
        return sb.toString();
    }
}
