package com.py.app.entrance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Spring could web程序主入口
 * @author jzl
 *
 */

@EnableAutoConfiguration//启用自动配置
@ImportResource("classpath*:spring/spring.xml")
@SpringBootApplication
public class EntranceApplication {
	public static void main(String[] args) {   
        //第一个简单的应用，   
        SpringApplication.run(EntranceApplication.class,args);
    }

}
