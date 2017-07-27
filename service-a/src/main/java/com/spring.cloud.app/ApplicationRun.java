package com.spring.cloud.app;

import feign.Logger;
import feign.Request;
import feign.Retryer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriTemplateHandler;

/**
 * 应用入口
 */

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class ApplicationRun {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationRun.class, args);

    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    public class FooConfiguration {
        @Bean
        Logger.Level feignLoggerLevel() {
            return Logger.Level.FULL;
        }
    }

    @Bean
    Request.Options feignOptions() {
        return new Request.Options(/**connectTimeoutMillis**/6 * 1000, /** readTimeoutMillis **/6 * 1000);
    }

    @Bean
    Retryer feignRetryer() {
        Retryer  retryer =  Retryer.NEVER_RETRY;
        return retryer;
    }
}
