package com.abiola.abiola;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableWebSecurity
// @EnableSwagger2
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public Docket api() {
        /*return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();*/
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/**"))
                .build().apiInfo(apiInfo()).useDefaultResponseMessages(false);

    }
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("Application name", "API description", "API TOS", "Terms of service", new Contact("Meeraj", "website", "email"), "License of API", "API license URL", Collections.emptyList());
        return apiInfo;
    }
    @Override
    protected void configure(HttpSecurity security) throws Exception
    {
        security.cors().and().csrf().disable();
        security.httpBasic().disable();
    }
}
