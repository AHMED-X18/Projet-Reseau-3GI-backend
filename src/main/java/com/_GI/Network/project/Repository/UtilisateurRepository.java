package com._GI.Network.project.Repository;

import com._GI.Network.project.Models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,String>{

    Utilisateur findByNom(String username);

    boolean existsByNom(String username);

    boolean existsByEmail(String email);

    Utilisateur findByEmail(String email);
}
