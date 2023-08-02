package com.avellar.venuewizard.api.config;

import com.google.common.base.Predicate;
import jdk.javadoc.doclet.Doclet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.avellar.venuewizard.api.security.utils.JwtTokenUtil;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@Profile("dev")
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis((Predicate<RequestHandler>) RequestHandlerSelectors.basePackage("com.kazale.pontointeligente.api.controllers"))
                .paths((Predicate<String>) PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(Collections.singletonList(apiKey()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Ponto Inteligente API")
                .description("Documentação da API de acesso aos endpoints do Ponto Inteligente.")
                .version("1.0")
                .build();
    }

    private ApiKey apiKey() {
        UserDetails userDetails;
        String token;
        try {
            userDetails = this.userDetailsService.loadUserByUsername("admin@kazale.com");
            token = this.jwtTokenUtil.obterToken(userDetails);
        } catch (Exception e) {
            token = "";
        }

        return new ApiKey("Bearer " + token, "Authorization", "header");
    }
}


