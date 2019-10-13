package com.wj.mail.api.controller;

import com.wj.mail.api.common.CommonResult;
import com.wj.mail.api.domin.ProductDetails;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: springLearnDemo <br>
 * @Description: http连接Controller <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-10-02 14:45
 **/
@Api(tags = "HttpConnectionController", description = "测试http请求超时")
@Controller
@RequestMapping("/httpConnection")
public class HttpConnectionController {

    @ApiOperation("测试http请求超时不返回")
    @RequestMapping(value = "/request1", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ProductDetails> request1() {
        try {
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ProductDetails productDetails = new ProductDetails();
        productDetails.setProdId(2000L);
        productDetails.setProdName("奔驰AMD");
        productDetails.setProdDec("奔驰性能最佳的汽车");
        return CommonResult.success(productDetails);
    }

    @ApiOperation("测试http请求超时不返回")
    @RequestMapping(value = "/request2", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ProductDetails> request2() {
        ProductDetails productDetails = new ProductDetails();
        productDetails.setProdId(2000L);
        productDetails.setProdName("奔驰AMD");
        productDetails.setProdDec("奔驰性能最佳的汽车");
        return CommonResult.success(productDetails);
    }

}
