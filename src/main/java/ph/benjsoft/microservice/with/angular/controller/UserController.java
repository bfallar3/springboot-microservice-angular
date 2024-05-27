package ph.benjsoft.microservice.with.angular.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ph.benjsoft.microservice.with.angular.model.UserResponse;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    @GetMapping("/api/greet")
    public Mono<ResponseEntity<UserResponse>> greet() throws InterruptedException {
        UserResponse response = new UserResponse();
        response.setData1("Hello");
        response.setData2("World");

        Thread.sleep(2000L);

        return Mono.just(ResponseEntity.ok(response));
    }

}
