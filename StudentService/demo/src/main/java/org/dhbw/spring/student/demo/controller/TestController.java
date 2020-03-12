package org.dhbw.spring.student.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 */
@RestController
@RequestMapping(path = "/")
public class TestController {

    @GetMapping("test2")
    public boolean getTest2() {
        return true;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "/test")
    public String test() {
        return "test";
    }
    
}