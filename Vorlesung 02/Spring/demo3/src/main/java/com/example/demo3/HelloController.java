package com.example.demo3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 */
@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class HelloController {

    @RequestMapping(value = "/hello")
    public String getHello() {
        return "Hello World!";
    }
}