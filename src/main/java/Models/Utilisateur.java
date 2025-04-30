package Models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table (name="utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="nom")
    private  String nom ;
    @Column(name="email")
    private String email;
    @Column(name="mot_de_passe")
    private String password;
    @Lob
    @Column(name="photo")
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

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
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
