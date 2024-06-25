package com.Bankify.Accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Bankify Application - Accounts MicroService API Documentation",
                description = "Rest API documentation for Accounts Microservices",
                version = "v1",
                contact = @Contact(
                        name = "SridharVadla",
                        email = "dummy123@gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://google.com/"
                )


        ),
        externalDocs = @ExternalDocumentation(
                description = "Accounts Microservice REST API Documenntation",
                url = "........."
        )
)
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
