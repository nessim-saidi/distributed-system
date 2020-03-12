package org.dhbw.spring.student.demo.controller;

import org.dhbw.spring.student.demo.model.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CourseController
 */
@RestController
public class CourseController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hallo Welt";
    }

    @GetMapping("/course")
    public Course getCourse() {
        Course c = new Course ((long) 1, "Neuer Kurs");
        return c;
    }

}