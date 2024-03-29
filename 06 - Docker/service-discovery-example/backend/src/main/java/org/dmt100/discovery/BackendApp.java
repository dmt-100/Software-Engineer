package org.dmt100.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BackendApp {

    public static void main(String[] args) {
        SpringApplication.run(BackendApp.class);
    }

}

@RestController
class BackendLogicController {

    @GetMapping("/ping")
    public String pong() {
        return "pong";
    }

}
