package org.dhbw.demo.spring.studentdemo.repositories;

import org.dhbw.demo.spring.studentdemo.model.Course;
import org.springframework.data.repository.CrudRepository;

/**
 * CourseRepository
 */
public interface CourseRepository extends CrudRepository<Course, Long>{

    
}