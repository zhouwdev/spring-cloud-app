package com.spring.cloud.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * 应用入口
 */

@SpringBootApplication
@EnableEurekaServer
public class ApplicationRun {

    public static void main(String[] args) throws Exception {
        SpringApplication.run( ApplicationRun.class, args);
    }
}
