package com.codechallenge.gateway.api_gateway.configs;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions.addRequestHeader;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;

@Configuration
public class RouteConfig {

    @Bean
    public RouterFunction<ServerResponse> gatewayRoutes() {
        return route("auth-service")
                .route(RequestPredicates.path("/auth/**"), 
                       HandlerFunctions.http("http://auth-service"))
                .filter(addRequestHeader("X-Gateway", "API-Gateway"))
                .build()
                
                .and(route("user-service")
                        .route(RequestPredicates.path("/api/users/**"),
                               HandlerFunctions.http("http://user-service"))
                        .build())
                
                .and(route("problem-service")
                        .route(RequestPredicates.path("/api/problems/**"),
                               HandlerFunctions.http("http://problem-service"))
                        .build())
                
                .and(route("submission-service")
                        .route(RequestPredicates.path("/api/submissions/**"),
                               HandlerFunctions.http("http://submission-service"))
                        .build());
    }
}
