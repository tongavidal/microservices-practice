package com.microservice.springboot.app.items;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean("RestClient")
    public RestTemplate registerRestTemplate() {
        return new RestTemplate();
    }
}
