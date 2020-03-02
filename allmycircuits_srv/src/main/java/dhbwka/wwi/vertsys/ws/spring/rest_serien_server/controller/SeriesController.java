/*
 * Copyright © 2020 Dennis Schulmeister-Zimolong (Original)
 * Nessim Saidi (Spring Boot Implementierung)
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbwka.wwi.vertsys.ws.spring.rest_serien_server.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dhbwka.wwi.vertsys.ws.spring.rest_serien_server.model.Episode;
import dhbwka.wwi.vertsys.ws.spring.rest_serien_server.model.Series;
import dhbwka.wwi.vertsys.ws.spring.rest_serien_server.repository.SeriesRepository;

/**
 * SeriesController
 */
@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class SeriesController {

    @Autowired
    SeriesRepository SeriesRepo;

    @RequestMapping(value = "/Series", method = RequestMethod.GET, produces = "application/json")
    public List<Series> allSeries() {
        final List<Series> allSeries = (List) SeriesRepo.findAll();
        return allSeries;
    }

    /**
     * GET /api/Series/
     *
     * GET /api/Series/?query=…
     *
     * Auslesen einer Liste von Serien. Optional kann an die URL der Parameter
     * ?query=… angehängt werden, um die Liste auf bestimmte Serien passend zum
     * übergebenen Suchbegriff zu begrenzen.
     *
     * @param query Suchbegriff
     * @return Eine Liste mit allen gefundenen Serien
     */
/*     public ResponseEntity<Series> findSeries(@RequestParam("query") @DefaultValue("") String query) {
        // TODO Erweiterung der Service-Schnittstelle um parametrisierte Queries
        // Muster: /api/series?title=Stranger%20Things
        final Series allSeries = // Serien über Query-Parameter ermitteln
        return new ResponseEntity<Series>(allSeries, HttpStatus.OK);
    } */

    /**
     * POST /api/Series/
     * 
     * Anlagen einer neuen Serie.
     * 
     * @param series Anzulegende Serie
     * @return Gespeicherte Serie
     * @throws ConstraintViolationException 
     */
    @RequestMapping(value = "/Series", method = RequestMethod.POST, produces = "application/json")
    public Series saveNewSeries(@RequestBody Series series){
        Series newSeries = SeriesRepo.save(series);
        return newSeries;
    }
    
    /**
     * GET /api/Series/{id}/
     *
     * Auslesen einer einzelnen Serie anhand ihrer ID.
     *
     * @param id Gesuchte Serien-Id
     * @return Gesuchte Serie oder null
     */
    @RequestMapping(value = "/Series/{id}", method = RequestMethod.GET, produces = "application/json")
    public Series getSeries(@PathVariable(value="id") Long id) {
        Optional<Series> foundSeries = SeriesRepo.findById(id);
        Series returnSeries = null;
        if (foundSeries.isPresent() ) {
            returnSeries = foundSeries.get();
        } 
        
        return returnSeries;
    }

    /**
     * PUT /api/Series/{id}
     *
     * Aktualisieren einer vorhandenen Serie.
     *
     * @param series Zu aktualisierende Serie
     * @return Gespeicherte Serie
     */
    @RequestMapping(value = "/Series/{id}", method = RequestMethod.PUT, produces = "application/json")
    public Series updateSeries(@PathVariable(value="id") Long id, @RequestBody Series updatedSeries) {
        // überschreibe bestehende Serie, falls sie gefunden wird
        return SeriesRepo.findById(id)
            .map(series -> {
                updatedSeries.setId(series.getId());            
            return SeriesRepo.save(updatedSeries);
          })
          // oder erstelle einen neuen Datensatz mit der vorgegebenen Id
          .orElseGet(() -> {
            updatedSeries.setId(id);
            return SeriesRepo.save(updatedSeries);
          });
    }

    /**
     * DELETE /api/Series/{id}/
     *
     * Löschen einer vorhandenen Serie.
     *
     * @param id Zu löschende Serie
     * @return Gelöschte Serie
     */
    @RequestMapping(value = "/Series/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public Series deleteSeries(@PathVariable(value="id") Long id) {
        Optional<Series> foundSeries = SeriesRepo.findById(id);
        Series deletedSeries = null;
        if (foundSeries.isPresent() ) {
            deletedSeries = foundSeries.get();
            SeriesRepo.deleteById(id);
        } 
        return deletedSeries;
    }

}