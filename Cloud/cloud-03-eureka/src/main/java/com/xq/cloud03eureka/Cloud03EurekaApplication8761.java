package com.xq.cloud03eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Cloud03EurekaApplication8761 {

    public static void main(String[] args) {
        SpringApplication.run(Cloud03EurekaApplication8761.class, args);
    }

}
