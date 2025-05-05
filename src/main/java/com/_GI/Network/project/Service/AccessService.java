package com._GI.Network.project.Service;

import com._GI.Network.project.Models.Access;
import com._GI.Network.project.Models.Id_access;
import com._GI.Network.project.Repository.AccessRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AccessService {

    @Autowired
    private AccessRepository accessRepository;

    public List<Access> findAll() {
        return accessRepository.findAll();
    }

    public Access findByDate(Date date) {
        return accessRepository.findByDateConnexion(date);
    }

    public Access createAccess(Access access) {
        if (accessRepository.existsById(access.getAccess())) {
            throw new RuntimeException("Accès déjà existant");
        }
        return accessRepository.save(access);
    }

    public @NotNull Optional<Access> findById(Id_access id) {
        return accessRepository.findById(id);
    }
}