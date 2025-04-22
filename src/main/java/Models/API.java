package Models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class API {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String id_API;
    private String nom;
    private String description;
    private String URL;

    @OneToMany(mappedBy = "API", cascade = CascadeType.ALL)
    private Set<Access> access;

    // Getters et setters

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId_API(String id_API) {
        this.id_API = id_API;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getNom() {
        return nom;
    }

    public String getId_API() {
        return id_API;
    }

    public String getDescription() {
        return description;
    }

    public String getURL() {
        return URL;
    }
}
