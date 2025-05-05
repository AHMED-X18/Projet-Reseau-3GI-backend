package com._GI.Network.project.Models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "api")
public class API {
    @Id
    @Column(name = "nom", nullable = false)
    private String nom;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "url", nullable = false)
    private String URL;

    @Column(name = "version")
    private String version;

    @Column(name = "activite", nullable = false)
    private boolean activite;

    @OneToMany(mappedBy = "api", cascade = CascadeType.ALL)
    private Set<Access> access;

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isActivite() {
        return activite;
    }

    public void setActivite(boolean activite) {
        this.activite = activite;
    }
}