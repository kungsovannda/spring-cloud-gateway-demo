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
                                .uri("lb://ORDER")
                )
                .route("auth", r ->
                        r.path("/oauth2/**")
                                .uri("lb://SPRING-AUTH-SERVER")
                )
                .route("next-frontend", r->
                        r.path("/**")
                                .uri("http://localhost:3000")
                )
                .build();

    }

}
