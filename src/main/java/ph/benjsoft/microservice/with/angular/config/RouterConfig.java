package ph.benjsoft.microservice.with.angular.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.resources;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> htmlRouter() {
        return route(GET("/"),
                request -> ok().contentType(MediaType.TEXT_HTML)
                        .bodyValue(new ClassPathResource("static/index.html")))
                .and(resources("/**", new ClassPathResource("static/")));
    }
}
