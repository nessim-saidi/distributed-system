package org.dhbw.demo.spring.studentdemo.controller;

import java.util.List;

import org.dhbw.demo.spring.studentdemo.model.Course;
import org.dhbw.demo.spring.studentdemo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CourseController
 */
@RestController
public class CourseController {
    
    @Autowired
    CourseRepository CourseRepo;
    
    @GetMapping("/course")
    public List<Course> getAllCourses() {
        return (List) CourseRepo.findAll();
    }
    
}