package com.taman.image.manager.infra.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {


    private final String appVersion;

    public SwaggerConfig(@Value("${app.version}") String appVersion) {
        this.appVersion = appVersion;
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Image Management Service REST API Documentation.")
                        .version(this.appVersion)
                        .license(new License()
                                .name("Apache-2.0 license")
                                .url("http://www.apache.org/licenses/LICENSE-2.0")));
    }

}
