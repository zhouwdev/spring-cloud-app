package com.spring.cloud.app.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/test", produces = {MediaType.APPLICATION_JSON_VALUE})
public class Test {
    @GetMapping("/hello/{p}")
    public String hello(@PathVariable(name = "p") String p) throws Exception {
        System.out.println("-----------------" + p);
        Thread.sleep(5000);
        return "hello";
    }
}