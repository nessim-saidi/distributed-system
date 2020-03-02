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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dhbwka.wwi.vertsys.ws.spring.rest_serien_server.model.Season;
import dhbwka.wwi.vertsys.ws.spring.rest_serien_server.model.Series;
import dhbwka.wwi.vertsys.ws.spring.rest_serien_server.model.SeasonId;
import dhbwka.wwi.vertsys.ws.spring.rest_serien_server.repository.SeasonRepository;
import dhbwka.wwi.vertsys.ws.spring.rest_serien_server.repository.SeriesRepository;

/**
 * SeasonController
 */
@RestController
@RequestMapping(value = "/api/Series/{id}/Season", produces = "application/json")
public class SeasonController {

    @Autowired
    SeriesRepository SeriesRepo;
    
    @Autowired
    SeasonRepository SeasonRepo;

    /**
     * GET /api/Series/{seriesId}/Season
     *
     * Auslesen aller Staffeln einer Serie.
     *
     * @param seriesId ID der Serie
     * @return Liste der gefundenen Staffeln
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Season> findAllSeasonsForSeries(@PathVariable(value="id") Long id) {

        // suche nach der zugehörigen Serie zur gegebenen Id
        Optional<Series> foundSeries = SeriesRepo.findById(id);
        List<Season> seasons = null;

        //falls die Serie gefunden wurde, suche nach zugehörigen Staffeln
        if(foundSeries.isPresent()) {
            SeasonId seasonId = new SeasonId(id, -1);
            List<Season> foundSeasons = SeasonRepo.findBySeries(foundSeries.get());
            // 
            if (!foundSeasons.isEmpty() ) {
                seasons = foundSeasons;
            }
        }        
        return seasons;   
    }

    /**
     * POST /api/Series/{seriesId}/Season
     * 
     * Neue Staffel zu einer Serie anlegen.
     * 
     * @param season Zu speichernde Staffel
     * @return Gespeicherte Staffel
     * @throws ConstraintViolationException 
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Season saveNewSeason(@RequestBody Season season) {
        return SeasonRepo.save(season);
    }

    /**
     * GET /api/Series/{seriesId}/Season/{seasonId}
     *
     * Auslesen einer einzelnen Staffel anhand ihrer ID.
     *
     * @param seriesId Gesuchte Serie
     * @param seasonNr Gesuchte Staffel
     * @return Gesuchte Staffel oder null
     */
    @RequestMapping(value = "/{seasonNr}" , method = RequestMethod.GET, produces = "application/json")
    public Season getSeason(@PathVariable(value="id") Long id, @PathVariable(value="seasonNr") Integer seasonNr) {
        SeasonId seasonId = new SeasonId(id, seasonNr);
        Season returnSeason = null;
        Optional<Season> foundSeason = SeasonRepo.findById(seasonId);
        if (foundSeason.isPresent()) {
            returnSeason = foundSeason.get();
        }
        return returnSeason;
    }

    /**
     * PUT /api/Series/{seriesId}/Season/{seasonId}
     *
     * Aktualisieren einer vorhandenen Staffel.
     *
     * @param seriesId Gesuchte Serie
     * @param seasonNr Gesuchte Staffel
     * @param season Zu aktualisierende Staffel
     * @return Gespeicherte Staffel
     */
    @RequestMapping(value = "/{seasonNr}", method = RequestMethod.PUT, produces = "application/json")
    public Season updateSeason( @PathVariable(value="id") Long id, @PathVariable("seasonNr") int seasonNr, @RequestBody Season season){
        Season updateSeason = null;
        Optional<Series> foundSeries = SeriesRepo.findById(id);
        if (foundSeries.isPresent()) {
            season.setSeries(foundSeries.get());
            season.setSeasonNumber(seasonNr);
            return SeasonRepo.save(season);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Series " + id + " Not Found");
        }
    }

    /**
     * DELETE /api/Series/{seriesId}/Season/{seasonId}
     *
     * Löschen einer vorhandenen Staffel.
     *
     * @param seriesId Gesuchte Serie
     * @param seasonNr Gesuchte Staffel
     * @return Gelöschte Staffel
     */
    @RequestMapping(value = "/{seasonNr}", method = RequestMethod.DELETE, produces = "application/json")
    public Season deleteSeason(@PathVariable(value="id") Long id, @PathVariable("seasonNr") int seasonNr ) {
        SeasonId seasonId = new SeasonId(id, seasonNr);
        Optional<Season> foundSeason = SeasonRepo.findById(seasonId);

        if (foundSeason.isPresent()) {
            SeasonRepo.delete(foundSeason.get());
            return foundSeason.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Series " + id + " Not Found");
        }        
    }
}