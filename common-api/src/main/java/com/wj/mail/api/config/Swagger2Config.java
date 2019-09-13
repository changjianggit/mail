package com.wj.mail.api.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: springLearnDemo <br>
 * @Description: Swagger2API文档配置类 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-07-02 14:17
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {

    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wj.mail.api.Controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("SwaggerUI接口展示")
                .description("Common-API")
                .contact("WuJiang")
                .version("1.0")
                .build();
    }
}
