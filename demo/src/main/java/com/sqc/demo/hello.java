package com.sqc.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
    @GetMapping("/hello-api")
    public String hello(@RequestParam(defaultValue = "A") String name,
                        @RequestParam(defaultValue = "B") String address ){
        return "hello" + " " + name + " " + address;
    }

}
