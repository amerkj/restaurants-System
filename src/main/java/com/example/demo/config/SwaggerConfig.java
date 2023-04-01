package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

}

//
//@EnableSwagger2
//@Configuration
//public class SwaggerConfig {
//
//    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
//                .paths(regex("/.*"))
//                .build();
//    }
//
//
//}

//.apis(RequestHandlerSelectors.basePackage("com.example.demo.advertisement.AdvertisementController"))
//                .apis(RequestHandlerSelectors.basePackage("com.example.demo.cuisinetype"))
//                .apis(RequestHandlerSelectors.basePackage("com.example.demo.featured"))
//                .apis(RequestHandlerSelectors.basePackage("com.example.demo.restaurant"))
//                .apis(RequestHandlerSelectors.basePackage("com.example.demo.user"))