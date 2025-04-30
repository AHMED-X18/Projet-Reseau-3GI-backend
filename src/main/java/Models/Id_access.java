package Models;

import jakarta.persistence.*;
import java.io.*;

@Embeddable
public class Id_access implements Serializable {
    private String nom_user;
    private String nom_api;

    public Id_access(String id_user, String nom_api){
        this.nom_user=id_user;
        this.nom_api=nom_api;
    }

    public String getNom_api() {
        return nom_api;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_api(String nom_api) {
        this.nom_api = nom_api;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }
}
