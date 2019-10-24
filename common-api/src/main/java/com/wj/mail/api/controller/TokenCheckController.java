package com.wj.mail.api.controller;

import com.wj.mail.api.annotation.ApiIdempotent;
import com.wj.mail.api.common.CommonResult;
import com.wj.mail.api.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springLearnDemo <br>
 * @Description: JwtController令牌必须类 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-10-13 20:48
 **/
@Api(tags = "TokenCheckController", description = "Token测试")
@RestController
@RequestMapping("/token")
public class TokenCheckController {

    @Autowired
    private TokenService tokenService;

    /**
     * 获取Token
     * @return
     */
    @ApiOperation("获取Token")
    @GetMapping("/getToken")
    public CommonResult getToken(){
        CommonResult commonResult = tokenService.createToken();
        return commonResult;
    }

    /**
     * 该接口需要带签名才能访问
     * @return
     */
    @ApiOperation("Token验证")
    @ApiIdempotent
    @PostMapping("/checkToken")
    public CommonResult checkToken(){

        return CommonResult.success("验证Token成功");
    }
}
