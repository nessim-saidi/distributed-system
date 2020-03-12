package org.dhbw.demo.spring.studentdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import lombok.Data;

/**
 * Course
 */
@Entity
@Data
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    
    private String title;
    
}