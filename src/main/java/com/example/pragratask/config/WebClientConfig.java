package com.example.pragratask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient.Builder webClientBuilder(){

        return WebClient.builder();
    }


}
