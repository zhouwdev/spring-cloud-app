package com.spring.cloud.app.api;

import com.spring.cloud.app.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class Test {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Hello hello;

    @GetMapping("/hello")
    public Object hello() {
        Map<String , Object> ps = new HashMap<String, Object>();
        ps.put("p","32434");
        Object object = restTemplate.getForEntity("http://service-b/api/test/hello?p={p}&a={a}", String.class, ps).getBody();
        return object;
    }

    @GetMapping("/hello2")
    public String hello2() {
        return hello.hello("sssss");
    }

}
