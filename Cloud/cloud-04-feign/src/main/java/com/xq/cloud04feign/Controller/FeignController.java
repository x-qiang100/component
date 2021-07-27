package com.xq.cloud04feign.Controller;

import com.xq.cloud04feign.Service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:xq
 * @date:2021/7/26 22:07
 * ClassName:FeignController
 * Package:com.xq.cloud04feign.Controller
 * Description:
 */
@RestController
public class FeignController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/web/hello")
    public String hello(){
        return helloService.hello();
    }
}
