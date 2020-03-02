package dhbwka.wwi.vertsys.ws.spring.rest_serien_server.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
     * GET /api/Series/{seriesId}/Season/
     *
     * Auslesen aller Staffeln einer Serie.
     *
     * @param seriesId ID der Serie
     * @return Liste der gefundenen Staffeln
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Season> findAllSeasonsForSeries(@PathVariable(value="id") Long id) {
        Optional<Series> foundSeries = SeriesRepo.findById(id);
        List<Season> seasons = null;
        if(foundSeries.isPresent()) {
            SeasonId seasonId = new SeasonId(id, -1);

            //Optional<Season> foundSeasons = SeasonRepo.findAllById(seasonId);
            
            /* if (foundSeasons.isPresent() ) {
                seasons = foundSeasons.get();
            }    */  

        }        
        return seasons;   
    }
    
}