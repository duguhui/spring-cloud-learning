package com.dugu.gatewaycenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@SpringBootApplication
@EnableZuulProxy
public class GatewayCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayCenterApplication.class, args);
    }
    @RestController
    public class Test{
        private final Logger logger = Logger.getLogger(getClass().toString());

        @Bean
        @LoadBalanced
        RestTemplate restTemplate(){
            return new RestTemplate();
        }

        @RequestMapping("/gateway")
        public String Trace()
        {
            logger.info("===< call gateway >===");
            try {
                System.out.println(getClass().toString());

                return restTemplate().getForEntity("http://localhost:5000/user/login",String.class).getBody();

            }catch (Exception e){

                return "失败:"+e.getMessage();
            }

        }
    }
}
