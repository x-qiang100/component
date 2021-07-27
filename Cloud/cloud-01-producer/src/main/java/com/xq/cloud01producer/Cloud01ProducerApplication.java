package com.xq.cloud01producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class Cloud01ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cloud01ProducerApplication.class, args);
    }

}
