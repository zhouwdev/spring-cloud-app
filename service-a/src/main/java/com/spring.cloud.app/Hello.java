package com.spring.cloud.app;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@FeignClient(serviceId = "service-b", fallback = HystruxHandle.class)
@Component
public interface Hello {

    @HystrixCommand(fallbackMethod = "hello")
    @RequestMapping(value = "/api/test/hello/{p}", method = RequestMethod.GET)
    public String hello(@PathVariable(name = "p") String p);


}
