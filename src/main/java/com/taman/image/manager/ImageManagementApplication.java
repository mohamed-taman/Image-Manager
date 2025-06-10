package com.taman.image.manager;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Starting point of Image Management Application.
 *
 * @author Mohamed Taman
 * @version 1.0
 */
@SpringBootApplication
@Log4j2
public class ImageManagementApplication {

    public static void main(String... args) {

        SpringApplication.run(ImageManagementApplication.class, args);
    }

    @Bean
    public ApplicationRunner atStartup() {
        return _ -> log.info("Image Management Application is Up & Running... ");
    }
}
