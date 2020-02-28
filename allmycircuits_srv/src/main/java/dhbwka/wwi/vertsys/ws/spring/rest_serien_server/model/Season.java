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
package dhbwka.wwi.vertsys.ws.spring.rest_serien_server.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;

import lombok.Data;
/* import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; */

/**
 * Season
 * @Getter @Setter @NoArgsConstructor
 */
@Data
@Entity
public class Season implements Serializable {

    @Id
    @ManyToOne
    private Series series = null;

    @Id
    private int seasonNumber = -1;

    private int releaseYear = -1;
    private int numberOfEpisodes = -1;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "SEASON_EPISODES"
    )
    @Column(name = "EPISODE")
    @OrderBy("nr ASC")
    private List<Episode> episodes = new ArrayList<>();        
    
}