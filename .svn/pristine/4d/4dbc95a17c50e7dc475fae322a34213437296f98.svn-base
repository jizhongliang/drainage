package com.py.app.borrow.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;

/**
 * Spring could web程序主入口
 * @author jzl
 *
 */

@EnableAutoConfiguration//启用自动配置
@EnableDiscoveryClient
@ImportResource("classpath*:spring/spring.xml")
@SpringBootApplication
public class ApplicationBorrow {
	public static void main(String[] args) {   
        //第一个简单的应用，   
        SpringApplication.run(ApplicationBorrow.class,args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
