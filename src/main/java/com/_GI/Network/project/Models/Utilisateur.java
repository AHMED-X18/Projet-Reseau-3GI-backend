package com._GI.Network.project.Models;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @Column(name = "nom")
    private String nom;

    @Column(name = "email")
    private String email;

    @Column(name = "mot_de_passe")
    private String password;

    @Lob
    @Column(name = "photo", columnDefinition = "BYTEA")
    @Transient
    private MultipartFile photoFile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Access> acces;

    @Version
    @Column(name="version", nullable=true)
    private Long version;

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MultipartFile getPhotoFile() {
        return photoFile;
    }

    public Long getVersion() { return version; }

    public void setPhotoFile(MultipartFile photoFile) {
        this.photoFile = photoFile;
    }
}