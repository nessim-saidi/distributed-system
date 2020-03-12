package org.dhbw.demo.spring.studentdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Student
 */
@Data
@Entity
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String firstName;
    String lastName;

    @ManyToOne
    Course course;

    public Student(String _first, String _last, Course _course) {
        this.firstName = _first;
        this.lastName = _last;
        this.course = _course;
    }
}