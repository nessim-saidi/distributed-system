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

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * Series
 */
@Data
@Entity
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //(strategy = GenerationType.AUTO)
    @Column(name = "series_id", updatable = false, nullable = false)
/*     @Column(name = "Id", nullable = false, precision = 3, scale = 0)
    @GeneratedValue(generator = "seq_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="seq_generator", sequenceName = "SEQ_ID_SERIES", allocationSize=1) */
    private Long id;

    @Column(length = 50)
    private String title = "";
    
    @Column(length = 50)
    private String genre = "";
    
    @Column(length = 20)
    private String country = "";

    private int fromYear = -1;
    private int toYear = -1;
    private int numberOfSeasons = -1;
    private int numberOfEpisodes = -1;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "series")
    private List<Season> seasons;

    public Series() {
    }

    public Series(Long id) {
        this.id = id;
    }
    
    public Series(Long id, String title, String genre, String country, int fromYear, int toYear, int numberOfSeasons, int numberOfEpisodes) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.country = country;
        this.fromYear = fromYear;
        this.toYear = toYear;
        this.numberOfSeasons = numberOfSeasons;
        this.numberOfEpisodes = numberOfEpisodes;
    }
        
    public Series( String title, String genre, String country, int fromYear, int toYear, int numberOfSeasons, int numberOfEpisodes) {
        this.title = title;
        this.genre = genre;
        this.country = country;
        this.fromYear = fromYear;
        this.toYear = toYear;
        this.numberOfSeasons = numberOfSeasons;
        this.numberOfEpisodes = numberOfEpisodes;
    }
}