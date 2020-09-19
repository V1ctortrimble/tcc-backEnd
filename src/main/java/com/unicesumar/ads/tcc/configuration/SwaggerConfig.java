package com.unicesumar.ads.tcc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

/**
 * Configuration class for implementing Swagger
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    /**
     * General Swagger configuration method and feature implementation
     * @return new Docket
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.unicesumar.ads.tcc"))
                .paths(PathSelectors.regex(".*"))
                .build()
                .securitySchemes(Arrays.asList(apiKey()))
                .apiInfo(apiInfo());
    }

    /**
     * Method of setting information on the Swagger page
     * @return new ApiInfoBuilder
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("TCC BACK-END REST API")
                .description("Rest Back-end API documentation")
                .version("1.0.0")
                .build();
    }

    /**
     * Method of setting authorize on the Swagger page
     * @return new ApiKey
     */
    private ApiKey apiKey() {
        return new ApiKey("jwtToken", "Authorization", "header");
    }
}