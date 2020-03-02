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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Episode
 */
@Data
@Entity
@RequiredArgsConstructor
public class Episode {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "episode_id", unique = true, nullable = false)    
    private long episode_id;

    private int nr = -1;

    private String title = "";

    public Episode(int _nr, String _title) {
        this.nr = _nr;
        this.title = _title;
	}

}