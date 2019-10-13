package com.wj.mail.api.controller;

import com.wj.mail.api.common.CommonResult;
import com.wj.mail.api.domin.ProductDetails;
import com.wj.mail.api.service.CancelOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: springLearnDemo <br>
 * @Description: 商品详情Controller <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-20 14:45
 **/
@Api(tags = "HomeController", description = "主页")
@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private CancelOrderService cancelOrderService;

    @ApiOperation("展示商品主页")
    @RequestMapping(value = "/content", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ProductDetails> content() {
        ProductDetails productDetails = new ProductDetails();
        productDetails.setProdId(2000L);
        productDetails.setProdName("奔驰AMD");
        productDetails.setProdDec("奔驰性能最佳的汽车");
        return CommonResult.success(productDetails);
    }

    @ApiOperation("模拟创建订单")
    @RequestMapping(value = "/createOrder", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ProductDetails> createOrder() {
        cancelOrderService.createOrder("TEST");
        ProductDetails productDetails = new ProductDetails();
        productDetails.setProdId(2000L);
        productDetails.setProdName("奔驰AMD");
        productDetails.setProdDec("奔驰性能最佳的汽车");
        return CommonResult.success(productDetails);
    }

}
