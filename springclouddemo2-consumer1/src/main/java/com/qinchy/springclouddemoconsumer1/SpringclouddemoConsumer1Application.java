package com.qinchy.springclouddemoconsumer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringclouddemoConsumer1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringclouddemoConsumer1Application.class, args);
    }

}