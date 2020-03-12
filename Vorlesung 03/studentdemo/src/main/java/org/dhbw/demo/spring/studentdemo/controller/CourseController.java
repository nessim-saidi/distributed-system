package org.dhbw.demo.spring.studentdemo.controller;

import java.util.List;
import java.util.Optional;

import org.dhbw.demo.spring.studentdemo.model.Course;
import org.dhbw.demo.spring.studentdemo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



/**
 * CourseController
 * 
 * RestController: Die Methoden dieser Klasse geben ein Domänenobjekt (und keine "View") zurück.
 * Kombination aus @Controller (ein Verarbeiter - "Handler" - für HTTP-Anfrage) 
 * und @ResponseBody (Returnwerte werden an HTTP-Body übergeben)
 */
@RestController
public class CourseController {
    
    /**
     * Automatisierte "Dependency Injection"
     * Es wird zur Laufzeit ein Course Repository an Klassenvariable CourseRepo gekoppelt. 
     */
    @Autowired
    CourseRepository CourseRepo;
    
    /**
     * Erhalte eine Liste von Kursen
     * 
     * Ein @RequestMapping vom HTTP-Typ "GET", das auf einem definierten Pfad angesprochen wird
     * d.h. eine HTTP-GET Anfrage auf den Pfad "/course" wird auf diese Methode gemappet.
     * @return  List<Course>
     */
    @GetMapping("/course")
    public List<Course> getAllCourses() {
        return (List) CourseRepo.findAll();
    }
    

    /**
     * Lege einen neuen Kurs an
     * 
     * Ein @RequestMapping vom HTTP-Typ "POST", das auf einem definierten Pfad angesprochen wird
     * d.h. eine HTTP-POST Anfrage auf den Pfad "/course" wird auf diese Methode gemappet.
     * Der neu anzulegende Kurs wird aus dem Body des HTTP-Pakets über die Annotation @RequestBody zu dem 
     * Eingangsparameter "newCourse" übergeben.
     * @param newCourse
     * @return Course
     */
    @PostMapping("/course")
    public Course createNewCourse(@RequestBody Course newCourse) {
        Course createdCourse = CourseRepo.save(newCourse);        
        return createdCourse;
    }
    
    /**
     * Löscht den Kurs mit der angegebenen Id
     * 
     * Ein @RequestMapping vom HTTP-Typ "DELETE", das auf einem definierten Pfad angesprochen wird
     * d.h. eine HTTP-DELETE Anfrage auf den Pfad "/course" wird auf diese Methode gemappet.
     * Die Id deszu löschenden Kurses wird als URL-Anfrage-Parameter übergeben und mit @RequestParam ausgelesen
     * z.B.: HTTP DELETE - localhost:8080/course?id=4
     * @param id
     * @return Course
     */
    @DeleteMapping("/course")
    public Course deleteCourseById(@RequestParam long id) {

        // findById() gibt entweder einen gefundenen Kurs oder nichts zurück. Dies wird mit dem Optional-Datentyp abgebildet
        Optional<Course> CourseToDelete = CourseRepo.findById(id);

        // ist der Optional-Datentyp mit einem Course-Objekt gefüllt?
        if(CourseToDelete.isPresent()) {
            // dann lösche den gefundenen Kurs
            CourseRepo.delete(CourseToDelete.get());
            return CourseToDelete.get();
        } else {
            // ansonsten gebe den Status 404 "Not found" zurück
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Kurs " + id + " nicht gefunden.");
        }
    }
}