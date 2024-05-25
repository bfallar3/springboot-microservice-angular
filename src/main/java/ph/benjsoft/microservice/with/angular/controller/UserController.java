package ph.benjsoft.microservice.with.angular.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ph.benjsoft.microservice.with.angular.model.UserResponse;

@RestController
public class UserController {

    @GetMapping("/api/greet")
    public ResponseEntity<UserResponse> greet() throws InterruptedException {
        UserResponse response = new UserResponse();
        response.setData1("Hello");
        response.setData2("World");

        Thread.sleep(2000L);

        return ResponseEntity.ok(response);
    }

}
