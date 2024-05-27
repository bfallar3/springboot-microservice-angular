package ph.benjsoft.microservice.with.angular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class MicroserviceWithAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceWithAngularApplication.class, args);
	}

}
