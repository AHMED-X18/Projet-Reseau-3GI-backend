package com._GI.Network.project.Models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Id_access implements Serializable {
    private String nom_user;
    private String nom_api;

    public Id_access() {} // Default constructor

    public Id_access(String nom_user, String nom_api) {
        this.nom_user = nom_user;
        this.nom_api = nom_api;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public String getNom_api() {
        return nom_api;
    }

    public void setNom_api(String nom_api) {
        this.nom_api = nom_api;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Id_access that)) return false;
        return Objects.equals(nom_user, that.nom_user) &&
                Objects.equals(nom_api, that.nom_api);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom_user, nom_api);
    }
}