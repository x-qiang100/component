package com.xq.cloud04feign.Service;

import org.springframework.stereotype.Component;

/**
 * @author:xq
 * @date:2021/7/26 22:09
 * ClassName:MyFallback
 * Package:com.xq.cloud04feign.Service
 * Description:
 */
@Component
public class MyFallback implements HelloService{


    @Override
    public String hello() {
        return "异常";
    }
}
