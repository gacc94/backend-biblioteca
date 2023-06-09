package com.pe.gacc.biblioteca;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BackendBibliotecaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendBibliotecaApplication.class, args);
    }

    @Bean
    public OpenAPI info(){
        return new OpenAPI()
                .info(new Info()
                        .title("app-biblioteca")
                        .description("API BIBLIOTECA YOUTUBE")
                        .contact(new Contact()
                                .email("gustavocaqui94@gmail.com")));
    }

}
