package com.spring.cloud.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


/**
 * 应用入口
 */


@SpringBootApplication
@EnableZuulProxy
public class ApplicationRun {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationRun.class, args);
    }
}
