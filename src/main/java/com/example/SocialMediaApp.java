package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import static org.springframework.boot.SpringApplication.run;

/**
 * This is a class that is used to run your application.
 *
 * DO NOT CHANGE ANYTHING IN THIS CLASS
 *
 */

@SpringBootApplication
@EnableAutoConfiguration
@Controller

public class SocialMediaApp {

    public static void main(String[] args) {
        SpringApplication.run(SocialMediaApp.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
