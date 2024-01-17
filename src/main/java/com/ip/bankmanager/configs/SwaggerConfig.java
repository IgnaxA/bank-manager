package com.ip.bankmanager.configs;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition (
    info = @Info (
        contact = @Contact (
            name = "Ignat",
            email = "ignat.panoff@gmail.com"
        ),
        description = "API documentation for bank manager test project",
        title = "REST API for bank manager"
    ),
    servers = {
        @Server (
            description = "Local ENV",
            url = "http://localhost:8080"
        )
    }
)
public class SwaggerConfig {
    
}
