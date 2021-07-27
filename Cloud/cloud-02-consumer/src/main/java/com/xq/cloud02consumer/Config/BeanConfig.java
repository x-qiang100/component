package com.xq.cloud02consumer.Config;

import com.netflix.eureka.registry.rule.InstanceStatusOverrideRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author:xq
 * @date:2021/7/22 20:09
 * ClassName:BeanConfig
 * Package:com.xq.cloud02consumer.Config
 * Description:
 */

//等价于Spring applicationContext.xml
@Configuration
public class BeanConfig {

    /**
     * 等价于
     * <bean id="" class=""><
     * bean/>
     *
     * @return
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }




}
