package co.istad.gatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRoute(RouteLocatorBuilder builder){
        return builder.routes()
                .route("order", r ->
                        r.path("/orders/**")
                                .uri("http://localhost:8081")
                )
                .route("auth", r ->
                        r.path("/oauth2/**")
                                .uri("http://localhost:9000")
                )
                .build();

    }

}
