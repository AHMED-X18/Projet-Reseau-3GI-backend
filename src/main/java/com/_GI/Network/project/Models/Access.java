package com._GI.Network.project.Models;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "access")
public class Access {

    @EmbeddedId
    private Id_access access;

    @ManyToOne
    @MapsId("nom_user")  // Use the field name in Id_access
    @JoinColumn(name = "nom")  // Column name in the database
    private Utilisateur user;

    @ManyToOne
    @MapsId("nom_api")  // Use the field name in Id_access
    @JoinColumn(name = "nom_api")  // Column name in the database (changed to 'nom_api')
    private API api;

    @Column(name = "date")
    private Date dateConnexion;

    @Column(name = "heure")
    private Time heureConnexion;

    // Getters et setters
    public Id_access getAccess() {
        return access;
    }

    public void setAccess(Id_access access) {
        this.access = access;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public API getApi() {
        return api;
    }

    public void setApi(API api) {
        this.api = api;
    }

    public Date getDateConnexion() {
        return dateConnexion;
    }

    public void setDateConnexion(Date dateConnexion) {
        this.dateConnexion = dateConnexion;
    }

    public Time getHeureConnexion() {
        return heureConnexion;
    }

    public void setHeureConnexion(Time heureConnexion) {
        this.heureConnexion = heureConnexion;
    }
}