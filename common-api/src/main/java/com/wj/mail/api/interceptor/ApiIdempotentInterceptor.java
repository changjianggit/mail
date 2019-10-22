package com.wj.mail.api.interceptor;

import com.wj.mail.api.annotation.ApiIdempotent;
import com.wj.mail.api.annotation.JwtToken;
import com.wj.mail.api.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @program: springLearnDemo <br>
 * @Description: 接口幂等性校验 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-10-22 21:34
 **/
@Component
public class ApiIdempotentInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) {
        // 如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)object;
        Method method=handlerMethod.getMethod();
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(ApiIdempotent.class)) {
            ApiIdempotent apiIdempotent = method.getAnnotation(ApiIdempotent.class);
            if (apiIdempotent != null) {
                tokenService.checkToken(httpServletRequest);
            }
        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
