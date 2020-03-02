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
package dhbwka.wwi.vertsys.ws.spring.rest_serien_server.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import dhbwka.wwi.vertsys.ws.spring.rest_serien_server.model.Season;
import dhbwka.wwi.vertsys.ws.spring.rest_serien_server.model.SeasonId;
import dhbwka.wwi.vertsys.ws.spring.rest_serien_server.model.Series;

public interface SeasonRepository extends CrudRepository<Season, SeasonId> {
    List<Season> findBySeries(Series series);
}