package com.qinchy.springclouddemoprovider2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringclouddemoProvider2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringclouddemoProvider2Application.class, args);
    }

}
