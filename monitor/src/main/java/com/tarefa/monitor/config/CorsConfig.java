package com.tarefa.monitor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedOrigins("http://localhost:4200") // Adicione o URL do seu aplicativo Angular
        .allowedMethods("GET", "POST", "PUT","PATCH", "DELETE", "OPTIONS")
        .allowCredentials(true);
    }

}
