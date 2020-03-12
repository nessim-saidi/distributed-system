package org.dhbw.vertsys.spring.student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CourseController
 */
@RestController
public class CourseController {

    @GetMapping("/")
    public String test() {
        return "Test";
    }


    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }
    
}