package com.qinchy.springclouddemoeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringclouddemoEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringclouddemoEurekaApplication.class, args);
    }

}
