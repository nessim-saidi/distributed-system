package org.dhbw.demo.spring.studentdemo.controller;

import java.util.List;

import org.dhbw.demo.spring.studentdemo.model.Student;
import org.dhbw.demo.spring.studentdemo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * StudentController
 */
@RestController
public class StudentController {

    @Autowired
    StudentRepository StudentRepo;

    //@RequestMapping (value = "/Student", method = RequestMethod.GET, produces = "application/json" )
    @GetMapping("/student")
    public List<Student> getStudents() {
        List<Student> students = (List) StudentRepo.findAll();
        return students;
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id) {
        Student s = StudentRepo.findById(id).get();
        return s;
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student newStudent) {
        Student s = StudentRepo.save(newStudent);
        return s;
    }
    
}