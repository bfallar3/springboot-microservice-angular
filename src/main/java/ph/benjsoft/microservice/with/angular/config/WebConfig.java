package ph.benjsoft.microservice.with.angular.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class WebConfig  {

    @Bean
    public RouterFunction<ServerResponse> indexRouter() {
        return route()
                .GET("/", request -> ok().bodyValue(new ClassPathResource("static/index.html")))
                .build();
    }
}
