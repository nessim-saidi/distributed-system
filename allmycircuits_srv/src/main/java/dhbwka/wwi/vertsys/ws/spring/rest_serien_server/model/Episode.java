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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
/* import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; */
import lombok.RequiredArgsConstructor;

/**
 * Episode
 * @Getter @Setter @NoArgsConstructor
 */
@Data
@Entity
@RequiredArgsConstructor
public class Episode {
    @Id
    @GeneratedValue
    private long Id;

    private int nr = -1;

    private String title = "";    
}