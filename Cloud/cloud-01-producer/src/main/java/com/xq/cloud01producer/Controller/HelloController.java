package com.xq.cloud01producer.Controller;

import com.xq.cloud01producer.enity.User;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

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
        String s = "服务提供者一";
        System.out.println(s);
        return "<h1>Hello World !"+s +"</h1>";
    }

    //支持get和post请求
    @RequestMapping("/service/getUser")
    public User getUser(@RequestParam("id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("age") Integer age){
        System.out.println("接收到请求 getUser");
         User user = new User(id, name, age);
        System.out.println("user = " + user);
        return user;
    }

    @RequestMapping(value = "/service/addUser", method = RequestMethod.POST)
    public User postUser(@RequestParam("id") Integer id,
                         @RequestParam("name") String name,
                         @RequestParam("age") Integer age){

        //插入数据库
        return new User(id, name, age);
    }
    @RequestMapping(value = "/service/updateUser", method = RequestMethod.PUT)
    public User putUser(@RequestParam("id") Integer id,
                         @RequestParam("name") String name,
                         @RequestParam("age") Integer age){

        //插入数据库
        User user = new User(id, name, age);
        System.out.println("user = " + user);
        return user;
    }

    @RequestMapping(value = "/service/deleteUser", method = RequestMethod.DELETE )
    public User deleteUser(@RequestParam("id") Integer id,
                        @RequestParam("name") String name,
                        @RequestParam("age") Integer age){

        System.out.println("DELETE");
        User user = new User(id, name, age);
        System.out.println("user = " + user);

        return user;
    }
}
