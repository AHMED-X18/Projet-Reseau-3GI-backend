package Models;

import jakarta.persistence.*;
import java.io.*;

@Embeddable
public class Id_access implements Serializable {
    private String nom_user;
    private String id_API;

    public Id_access(String id_user, String id_API){
        this.nom_user=id_user;
        this.id_API=id_API;
    }

    public String getId_API() {
        return id_API;
    }

    public String getId_user() {
        return nom_user;
    }

    public void setId_API(String id_API) {
        this.id_API = id_API;
    }

    public void setId_user(String id_user) {
        this.nom_user = id_user;
    }
}
