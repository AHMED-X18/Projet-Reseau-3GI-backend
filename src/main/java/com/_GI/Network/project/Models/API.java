package com._GI.Network.project.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "api")
@Data
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

}