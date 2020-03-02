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

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Season
 */
@Data
@Entity
@IdClass(SeasonId.class)
@NoArgsConstructor
public class Season implements Serializable {

	@Id
    @ManyToOne
    @JsonIgnoreProperties("seasons")        // Zirkulären Aufruf bei JSON-Serialisierung verhindern
    @JoinColumn(name = "series_id", insertable = false, updatable = false)
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
    @OneToMany(cascade = {CascadeType.ALL} )
    @JoinColumn(name = "episode_id", insertable = false, updatable = false)
    private List<Episode> episodes = new ArrayList<>();        
    
    public Season(Series _series, int _season, int _year, String[] _episodes) {
        List<Episode> newEpisodes = new ArrayList<Episode>();
        int episodeNr = 1;

        this.series = _series;
        this.seasonNumber = _season;
        this.releaseYear = _year;
        this.numberOfEpisodes = _episodes.length;

        // erstelle eine Episode je Titel aus dem String-Array
        for (String ep : _episodes) {
            newEpisodes.add(new Episode(episodeNr++, ep));
        }

        this.episodes = newEpisodes;
    }

}