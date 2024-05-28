package ph.benjsoft.microservice.with.angular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ph.benjsoft.microservice.with.angular.model.User;
import ph.benjsoft.microservice.with.angular.model.UserResponse;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/api/greet")
    public Mono<ResponseEntity<UserResponse>> greet() throws InterruptedException {
        UserResponse response = new UserResponse();
        String url = "http://localhost:9090/v1/user";

        User userObj = restTemplate.getForObject(url, User.class);
        if(userObj != null) {
            response.setData1(userObj.getName());
            response.setData2(userObj.getCity());
        } else {
            response.setData1("<unknown>");
            response.setData2("<unknown>");
        }

        Thread.sleep(2000L);

        return Mono.just(ResponseEntity.ok(response));
    }

}
