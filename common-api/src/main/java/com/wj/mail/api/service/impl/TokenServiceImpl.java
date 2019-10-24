package com.wj.mail.api.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.wj.mail.api.common.CommonResult;
import com.wj.mail.api.service.RedisService;
import com.wj.mail.api.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: springLearnDemo <br>
 * @Description: Token处理实现类 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-10-22 21:38
 **/
@Service
public class TokenServiceImpl implements TokenService {

    private static final String TOKEN_KEY = "tokenNew";
    private static final String TOKEN_PREFIX = "token:";

    @Autowired
    private RedisService redisService;

    @Override
    public CommonResult createToken() {
        String token = RandomUtil.randomString(32);
        StringBuilder tokenSb = new StringBuilder();
        tokenSb.append(TOKEN_PREFIX).append(token);
        String tokenWithPrefix = tokenSb.toString();
        redisService.set(tokenWithPrefix, tokenWithPrefix);
        redisService.expire(tokenWithPrefix, 60000);
        Map<String, Object> result = new HashMap<>();
        result.put(TOKEN_KEY, tokenWithPrefix);
        return CommonResult.success(result);
    }

    @Override
    public void checkToken(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_KEY);
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter(TOKEN_KEY);
            if (StringUtils.isEmpty(token)) {
                throw new RuntimeException("Don't find token");
            }
        }
        String tokenRedis = redisService.get(token);
        if (StringUtils.isEmpty(tokenRedis)) {
            throw new RuntimeException("Don't find token in redis");
        }
        boolean deleteResult = redisService.removeWithResult(token);
        if (!deleteResult) {
            throw new RuntimeException("Delete token in redis failed");
        }
    }
}
