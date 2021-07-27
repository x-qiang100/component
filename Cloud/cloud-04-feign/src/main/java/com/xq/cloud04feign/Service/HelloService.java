package com.xq.cloud04feign.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:xq
 * @date:2021/7/26 22:04
 * ClassName:HelloService
 * Package:com.xq.cloud04feign.Service
 * Description:
 */
@FeignClient(value = "cloud-01-producer", fallback = MyFallback.class)
public interface HelloService {

    @RequestMapping("/service/hello")
    public String  hello();

}
