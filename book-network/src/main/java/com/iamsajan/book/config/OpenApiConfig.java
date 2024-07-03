package com.iamsajan.book.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Sajan Kc",
                        email = "sajankcofficial@gmail.com",
                        url = "https://kcsajan.com.np/"
                ),
                title = "Book Network API",
                version = "1.0",
                description = "Documentation for Book Network API v1.0",
                license = @License(
                        name = "Licence name",
                        url = "https://iamsajan.com/"
                ),
                termsOfService = "https://iamsajan.com/"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8088/api/v1",
                        description = "Local ENV"
                ),
                @Server(
                        url = "https://kcsajan.com.np/api/v1",
                        description = "Production ENV"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
