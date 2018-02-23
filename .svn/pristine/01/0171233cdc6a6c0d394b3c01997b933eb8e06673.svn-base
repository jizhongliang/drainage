package com.py.merchant.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author jinlilong
 * @version $Id: Swagger2Config.java, v 0.1 2017年12月13日 下午7:56:31 jinlilong Exp $
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Value("${swagger2.config.package}")
    private String configPath;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
            .apis(RequestHandlerSelectors.basePackage(configPath)).paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("产品服务API文档").version("1.0").build();
    }

}
