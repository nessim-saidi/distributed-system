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

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User
 * @Getter @Setter @NoArgsConstructor
 */
@Data
@Entity
@Table(name = "REST_USER")
public class User {
    @Id
    @Column(name = "USERNAME", length = 64)
    private String username;

    @Column(name = "PASSWORD_HASH", length = 64)
    private String passwordHash;
    
    @ElementCollection
    @CollectionTable(
            name = "REST_USER_GROUP"
            //joinColumns = @JoinColumn(name = "USERNAME")
    )
    @Column(name = "GROUPNAME")
    private List<String> groups = new ArrayList<>();
}