package com.xq.cloud01producer02.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:xq
 * @date:2021/7/22 19:35
 * ClassName:HelloController
 * Package:com.xq.cloud01producer.Controller
 * Description:
 */
@RestController
public class HelloController {

    @RequestMapping("/service/hello")
    public String hello(){

//        int i = 10/0;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String s = "服务提供者二";
        System.out.println(s);
        return "<h1>Hello World !"+s +"</h1>";
    }
}
