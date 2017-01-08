package com.cheney.web.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)  
          .apiInfo(apiInfo())
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.cheney.web.controller"))              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("GenCode的API接口文档")
                .description("关于本项目的所有RESTful接口，提供web或app访问")
                .termsOfServiceUrl("http://gencode.duapp.com/")
                .version("1.0")
                .build();
    }
}
