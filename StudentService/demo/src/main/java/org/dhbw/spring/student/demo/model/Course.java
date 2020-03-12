package org.dhbw.spring.student.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Course
 */
@Entity
@Data
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;
    public String title;
    
    public Course (String _title) {
        this.title = _title;
    }

    public Course (Long _id, String _title) {
        this.Id = _id;
        this.title = _title;
    }
}