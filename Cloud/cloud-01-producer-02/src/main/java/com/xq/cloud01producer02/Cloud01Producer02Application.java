package com.xq.cloud01producer02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Cloud01Producer02Application {

    public static void main(String[] args) {
        SpringApplication.run(Cloud01Producer02Application.class, args);
    }

}
