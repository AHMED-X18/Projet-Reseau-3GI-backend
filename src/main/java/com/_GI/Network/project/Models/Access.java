package com._GI.Network.project.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "access")
@Data
public class Access {

    @EmbeddedId
    private Id_access access;

    @ManyToOne
    @MapsId("nom_user")  // Use the field name in Id_access
    @JoinColumn(name = "login")  // Column name in the database
    private Utilisateur user;

    @ManyToOne
    @MapsId("nom_api")  // Use the field name in Id_access
    @JoinColumn(name = "nom_api")  // Column name in the database (changed to 'nom_api')
    private API api;

    @Column(name = "date")
    private Date dateConnexion;

    @Column(name = "heure")
    private Time heureConnexion;

}