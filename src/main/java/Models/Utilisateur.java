package Models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id_user;
    private  String nom ;
    private String email;
    private String password;
    @Lob
    private byte[] photo;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private Set<Access> acces;

    // Getters et setters


    public byte[] getPhoto() {
        return photo;
    }

    public String getEmail() {
        return email;
    }

    public String getId_user() {
        return id_user;
    }

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

}
