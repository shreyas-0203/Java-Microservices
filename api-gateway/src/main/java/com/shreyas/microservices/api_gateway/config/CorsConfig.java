// package com.shreyas.microservices.api_gateway.config;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration
// class CorsConfig implements WebMvcConfigurer {

//     @Override
//     public void addCorsMappings(@SuppressWarnings("null") CorsRegistry registry) {
//         registry.addMapping("/api/**")
//                 .allowedMethods("*")
//                 .allowedHeaders("*")
//                 .allowedOriginPatterns("*")
//                 .allowCredentials(false);
//     }
// }