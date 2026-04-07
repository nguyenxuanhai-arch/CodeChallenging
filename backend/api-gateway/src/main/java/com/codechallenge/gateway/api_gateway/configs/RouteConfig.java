package com.codechallenge.gateway.api_gateway.configs;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-service", r -> r
                        .path("/auth/**")
                        .filters(f -> f.addRequestHeader("X-Gateway", "API-Gateway"))
                        .uri("lb://auth-service"))
                
                .route("user-service", r -> r
                        .path("/api/users/**")
                        .filters(f -> f.addRequestHeader("X-Gateway", "API-Gateway"))
                        .uri("lb://user-service"))
                
                .route("problem-service", r -> r
                        .path("/api/problems/**")
                        .filters(f -> f.addRequestHeader("X-Gateway", "API-Gateway"))
                        .uri("lb://problem-service"))
                
                .route("submission-service", r -> r
                        .path("/api/submissions/**")
                        .filters(f -> f.addRequestHeader("X-Gateway", "API-Gateway"))
                        .uri("lb://submission-service"))
                
                .build();
    }
}
