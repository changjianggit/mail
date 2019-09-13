package com.wj.mail.api.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @program: springLearnDemo <br>
 * @Description: Spring安全配置类 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-20 16:20
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置不需要登录验证
        http.authorizeRequests().anyRequest().permitAll().and().logout().permitAll().and().csrf().disable();
    }
}
