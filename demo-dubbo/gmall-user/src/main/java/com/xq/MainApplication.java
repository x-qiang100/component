package com.xq;


import java.io.IOException;

import com.alibaba.dubbo.registry.RegistryFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApplication {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("provider.xml");
        ioc.start();


        System.in.read();
    }

}

