package com.xq;


import java.io.IOException;
import java.util.List;

import com.xq.Service.OrderService;
import com.xq.bean.UserAddress;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApplication {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml");

        OrderService orderService = applicationContext.getBean(OrderService.class);

        List<UserAddress> list= orderService.initOrder("1");
        for (UserAddress userAddress : list) {
            System.out.println("userAddress = " + userAddress);
        }

        System.out.println("调用完成....");
        System.in.read();
    }

}
