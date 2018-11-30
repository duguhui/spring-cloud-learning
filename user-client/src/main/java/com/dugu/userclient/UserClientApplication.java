package com.dugu.userclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@SpringBootApplication
@EnableEurekaClient
public class UserClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserClientApplication.class, args);
    }
    @RestController
    public class Test{

        private final Logger logger = Logger.getLogger(getClass().toString());


        @RequestMapping("/login")
        public String login()
        {
            logger.info("===< call user >===");
            return "login success!";
        }
    }
}
