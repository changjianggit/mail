package com.wj.mail.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.wj.mail.api.annotation.JwtToken;
import com.wj.mail.api.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @program: springLearnDemo <br>
 * @Description: JwtController令牌必须类 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-10-13 20:48
 **/
@Api(tags = "JwtController", description = "Jwt测试")
@RestController
@RequestMapping("/jwt")
public class JwtController {
    /**
     * 登录并获取token
     * @param userName
     * @param passWord
     * @return
     */
    @ApiOperation("登录")
    @PostMapping("/login")
    public Object login( String userName, String passWord){
        JSONObject jsonObject=new JSONObject();
        // 检验用户是否存在(为了简单，这里假设用户存在，并制造一个uuid假设为用户id)
        String userId = UUID.randomUUID().toString();
        // 生成签名
        String token= JwtUtil.sign(userId);
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("userId", userId);
        userInfo.put("userName", userName);
        userInfo.put("passWord", passWord);
        jsonObject.put("token", token);
        jsonObject.put("user", userInfo);
        return jsonObject;
    }
    /**
     * 该接口需要带签名才能访问
     * @return
     */
    @ApiOperation("jwt验证")
    @JwtToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}
