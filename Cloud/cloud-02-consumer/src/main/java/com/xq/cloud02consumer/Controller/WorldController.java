package com.xq.cloud02consumer.Controller;

import com.xq.cloud02consumer.enity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:xq
 * @date:2021/7/22 20:06
 * ClassName:WorldController
 * Package:com.xq.cloud02consumer.Controller
 * Description:
 */
@RestController
public class WorldController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/web/world")
    public String  world(){

        //逻辑判断
        //调用远程Spring Cloud服务
//        return restTemplate.getForEntity("http://localhost:8080/service/hello", String.class).getBody();

        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://CLOUD-01-PRODUCER/service/hello", String.class);
        System.out.println("responseEntity.getStatusCodeValue() = " + responseEntity.getStatusCodeValue());
        System.out.println("responseEntity.getStatusCode() = " + responseEntity.getStatusCode());
        System.out.println("responseEntity.getBody() = " + responseEntity.getBody());
        System.out.println("responseEntity.getHeaders() = " + responseEntity.getHeaders());

        return restTemplate.getForEntity("http://CLOUD-01-PRODUCER/service/hello",String.class ).getBody();
    }

    @RequestMapping("/web/getUser")
    public User getUser(){

        //逻辑判断
        //调用远程Spring Cloud服务
//        return restTemplate.getForEntity("http://localhost:8080/service/hello", String.class).getBody();
        String[] strs = {"12", "小狼", "8"};

        Map<String, Object> map = new HashMap<>();
        map.put("id",15);
        map.put("name","张");
        map.put("age",10);

        ResponseEntity<User> responseEntity =
//                restTemplate.getForEntity("http://CLOUD-01-PRODUCER/service/getUser?id={0}&name={1}&age={2}", User.class, strs);
                restTemplate.getForEntity("http://CLOUD-01-PRODUCER/service/getUser?id={id}&name={name}&age={age}", User.class, map);

//        restTemplate.getForObject();
        System.out.println("responseEntity.getStatusCodeValue() = " + responseEntity.getStatusCodeValue());
        System.out.println("responseEntity.getStatusCode() = " + responseEntity.getStatusCode());
        System.out.println("responseEntity.getBody() = " + responseEntity.getBody());
        System.out.println("responseEntity.getHeaders() = " + responseEntity.getHeaders());

//        return restTemplate.getForEntity("http://CLOUD-01-PRODUCER/service/getUser?id={0}&name={1}&age={2}", User.class, strs).getBody();
        return restTemplate.getForEntity("http://CLOUD-01-PRODUCER/service/getUser?id={id}&name={name}&age={age}", User.class, map).getBody();
    }

    @RequestMapping("/web/addUser")
    public User addUser(){

        String[] strs = {"12", "小狼", "8"};


        //要传的信息，表单数据
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("id",15);
        map.add("name","小谢");
        map.add("age",20);

        ResponseEntity<User> responseEntity =
                restTemplate.postForEntity("http://CLOUD-01-PRODUCER/service/addUser", map,User.class);

        User user = restTemplate.postForObject("http://CLOUD-01-PRODUCER/service/addUser", map,User.class );
        User user2 = restTemplate.postForObject("http://CLOUD-01-PRODUCER/service/getUser", map,User.class );

        System.out.println("user = " + user);
        System.out.println("user = " + user2);

        System.out.println("responseEntity.getStatusCodeValue() = " + responseEntity.getStatusCodeValue());
        System.out.println("responseEntity.getStatusCode() = " + responseEntity.getStatusCode());
        System.out.println("responseEntity.getBody() = " + responseEntity.getBody());
        System.out.println("responseEntity.getHeaders() = " + responseEntity.getHeaders());

        return  restTemplate.postForEntity("http://CLOUD-01-PRODUCER/service/addUser", map,User.class).getBody();

    }

    @RequestMapping("/web/updateUser")
    public String updateUser(){

        //要传的信息，表单数据
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("id",15);
        map.add("name","小谢");
        map.add("age",20);

        //测试不限制请求方式
        restTemplate.put("http://CLOUD-01-PRODUCER/service/getUser", map );

        restTemplate.put("http://CLOUD-01-PRODUCER/service/updateUser", map);

        return "success";
    }

    @RequestMapping("/web/deleteUser")
    public String deleteUser(){

        //要传的信息，表单数据
        Map<String, Object> map = new HashMap<>();
        map.put("id",15);
        map.put("name","小谢");
        map.put("age",20);

        //测试不限制请求方式
        restTemplate.delete("http://CLOUD-01-PRODUCER/service/getUser?id={id}&name={name}&age={age}", map );

        restTemplate.delete("http://CLOUD-01-PRODUCER/service/deleteUser?id={id}&name={name}&age={age}", map);

        return "success";
    }

    @GetMapping("/testCircuitBreaker")
    public String testCircuitBreaker() {
        String s = "hello cxy35:" ;
        System.out.println(s);
        int i = 1 / 0;
        return "testCircuitBreaker: " + s;
    }


}
