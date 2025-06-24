package com._GI.Network.project.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "utilisateur")
@Data
public class Utilisateur {
    @Id
    @Column(name="login")
    private String login;

    @Column(name = "nom")
    private String nom;

    @Column(name = "email")
    private String email;

    @Column(name = "mot_de_passe")
    private String password;

    @Lob
    @Column(name = "photo", columnDefinition = "BYTEA")
    @Transient
    private byte[] photoFile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Access> acces;

    @Version
    @Column(name="version", nullable=true)
    private Long version;
}