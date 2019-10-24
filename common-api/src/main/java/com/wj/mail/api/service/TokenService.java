package com.wj.mail.api.service;

import com.wj.mail.api.common.CommonResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: springLearnDemo <br>
 * @Description: Token接口类 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-10-22 21:35
 **/
public interface TokenService {

    CommonResult createToken();

    void checkToken(HttpServletRequest request);
}
