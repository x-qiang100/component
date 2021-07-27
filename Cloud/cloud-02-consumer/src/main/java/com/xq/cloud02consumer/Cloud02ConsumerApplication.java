package com.xq.cloud02consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@SpringBootApplication
@EnableEurekaClient
public class Cloud02ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cloud02ConsumerApplication.class, args);
    }

}
