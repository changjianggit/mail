package com.wj.mail.api.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: springLearnDemo <br>
 * @Description: web配置类<br>
 * @author: Wu.Jiang <br>
 * @create: 2019-10-13 18:02
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Autowired
    private ApiIdempotentInterceptor apiIdempotentInterceptor;

    /**
     * 添加jwt拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                // 拦截所有请求，通过判断是否有 @JwtToken 注解 决定是否需要登录
                .addPathPatterns("/**");
        registry.addInterceptor(apiIdempotentInterceptor)
                // 拦截所有请求，通过判断是否有 @ApiIdempotent 注解 判断幂等性
                .addPathPatterns("/**");
    }

}