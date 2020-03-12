package org.dhbw.demo.spring.studentdemo.repositories;

import org.dhbw.demo.spring.studentdemo.model.Course;
import org.springframework.data.repository.CrudRepository;

/**
 * CourseRepository
 * 
 * Spring Data Repositories erleichtern das Entwickeln der Datenzugriffsebene einer Anwendung - also
 * den Teil, der für den Zugriff auf persistente Datenspeicher wie z.B. eine Datenbank verantwortlich 
 * sind. Dieses spezielle CrudRepository bietet dazu, wie der Name bereits andeutet, 
 * Standardimplementierungen für CRUD-Methoden, darunter save, findOne, findAll, count, delete, exists,...
 * 
 * Um ein einfaches Repository zu erstellen, musst du nur ein Interface definieren, das ein vordefiniertes
 * Repository erweitert. In diesem Fall ist es ein CRUD-Repository, welches Course-Objekte verwaltet, die 
 * einen Schlüssel vom Typ Long verwenden.
 * 
 */
public interface CourseRepository extends CrudRepository<Course, Long>{
    
}