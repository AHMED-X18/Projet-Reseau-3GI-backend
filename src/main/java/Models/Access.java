package Models;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
public class Access {
    @EmbeddedId
    private Id_access access;

    @ManyToOne
    @MapsId("Id_user")
    @JoinColumn(name="Id_user")
    private Utilisateur user;

    @ManyToOne
    @MapsId("Id_API")
    @JoinColumn(name="Id_API")
    private API API;

    private Date date_connexion;
    private Time heure_connexion;

    // Getters et setters


    public Id_access getAccess() {
        return access;
    }

    public API getAPI() {
        return API;
    }

    public void setAccess(Id_access access) {
        this.access = access;
    }

    public Date getDate_connexion() {
        return date_connexion;
    }

    public Time getHeure_connexion() {
        return heure_connexion;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setAPI(API API) {
        this.API = API;
    }

    public void setDate_connexion(Date date_connexion) {
        this.date_connexion = date_connexion;
    }

    public void setHeure_connexion(Time heure_connexion) {
        this.heure_connexion = heure_connexion;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
}
