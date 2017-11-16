package cn.derek.springcloud.learning.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AuthBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(AuthBootStrap.class, args);
    }
}
