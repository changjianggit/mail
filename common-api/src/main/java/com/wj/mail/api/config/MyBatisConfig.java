package com.wj.mail.api.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置类
 * Created by WuJiang on 2019/07/03.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.wj.mail.mapper","com.wj.mail.dao"})
public class MyBatisConfig {
}
