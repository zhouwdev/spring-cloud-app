package com.spring.cloud.app;

import org.springframework.stereotype.Component;

@Component
public class HystruxHandle implements Hello {

    public String hello(String p) {
        return "error";
    }
}
