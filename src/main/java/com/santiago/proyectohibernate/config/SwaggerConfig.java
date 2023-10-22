package com.santiago.proyectohibernate.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Proyecto Final Hibernate")
                        .version("1.0")
                        .description("Api Rest desarrollada para almacesar la informacion de usuarios asignarles tareas y su seguimiento")
                        .termsOfService("http://swagger.io/term/")
                        .contact(new Contact()
                                .name("David Santiago")
                                .email("davidsantiago434@gmail.com")
                                .url("http://www.github.com/dasv21"))
                        .license(new License().name("MIT").url("http://springdoc.arg")));
    }
}
