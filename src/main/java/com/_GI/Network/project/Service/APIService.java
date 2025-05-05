package com._GI.Network.project.Service;

import com._GI.Network.project.Models.API;
import com._GI.Network.project.Repository.APIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class APIService {

    @Autowired
    private APIRepository apiRepository;

    public List<API> findAll() {
        return apiRepository.findAll();
    }

    public API findByName(String nom) {
        return apiRepository.findByNom(nom);
    }

    public API updateAPI(String nom, API api) {
        API existingApi = findByName(nom);
        if (existingApi == null) {
            throw new RuntimeException("Pas d'API trouvé");
        }
        existingApi.setDescription(api.getDescription());
        existingApi.setURL(api.getURL());
        existingApi.setNom(api.getNom());
        return apiRepository.save(existingApi);
    }

    public void deleteAPI(String identifiant) {
        API api = findByName(identifiant);
        if (api == null) {
            throw new RuntimeException("API non trouvé");
        }
        apiRepository.delete(api);
    }

    public boolean existById(String id) {
        return apiRepository.existsById(id);
    }
}