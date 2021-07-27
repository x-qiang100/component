package com.xq.cloud04feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class Cloud04FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cloud04FeignApplication.class, args);
    }

}
