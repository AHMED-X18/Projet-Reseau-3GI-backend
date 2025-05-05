package com._GI.Network.project.Repository;

import com._GI.Network.project.Models.API;
import org.springframework.data.jpa.repository.JpaRepository;

public interface APIRepository extends JpaRepository<API, String> {
    API findByNom(String nom);
    boolean existsByNom(String nom);
}