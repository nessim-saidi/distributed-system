package org.dhbw.demo.spring.studentdemo.repositories;

import org.dhbw.demo.spring.studentdemo.model.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * StudentRepository
 */
public interface StudentRepository extends CrudRepository<Student, Long>{
    
}