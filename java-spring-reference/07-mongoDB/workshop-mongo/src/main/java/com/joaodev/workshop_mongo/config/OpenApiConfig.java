package com.joaodev.workshop_mongo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI dsmovieAPI() {
        return new OpenAPI()
           .info(new Info()
           .title("workshop-mongo")
           .description("workshop-mongo-devsuperior Reference Project")
           .version("v0.0.1")
           .license(new License()
           .name("Apache 2.0")
           .url("https://github.com/Joao-Victor-Teixeira/devsuperior-spring-journey/tree/main/java-spring-reference/07-mongoDB/workshop-mongo")));
    }
}
