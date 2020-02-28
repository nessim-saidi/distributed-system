package dhbwka.wwi.vertsys.ws.spring.rest_serien_server.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        // TODO service call
        final Series allSeries = new Series(0, "All my Circuits", "Comedy", "US", 2608, 2714, 106, 34251);
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
        Series transportSeries = null;
        if (foundSeries.isPresent() ) {
            transportSeries = foundSeries.get();
        } 
            return transportSeries;
    }

    /**
     * PUT /api/Series/{id}/
     *
     * Aktualisieren einer vorhandenen Serie.
     *
     * @param series Zu aktualisierende Serie
     * @return Gespeicherte Serie
     */
    @RequestMapping(value = "/Series/{id}", method = RequestMethod.PUT, produces = "application/json")
    public Series updateSeries(@PathVariable(value="id") Long id, @RequestBody Series series) {
        // TODO service call
        Series newSeries = new Series();
        return newSeries;
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

    // TODO refactor move or check if required
    @RequestMapping(value = "/Episodes", method = RequestMethod.GET, produces = "application/json")
    public Episode getEpisodes() {
        final Episode ep = new Episode();
        //final Series allSeries = new Series("0", "All my Circuits", "Comedy", "US", 2608, 2714, 106, 34251);
        //ep.setTitle("Automatron");
        return ep;
    }
    
}